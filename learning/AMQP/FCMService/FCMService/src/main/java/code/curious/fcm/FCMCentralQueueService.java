package code.curious.fcm;

import code.curious.fcm.model.DefaultPushNotificationEmitter;
import code.curious.fcm.model.NotificationResponse;
import code.curious.fcm.model.SubsNotificationEmitter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Service
public class FCMCentralQueueService {
    private static final Map<String, AbstractMessageListenerContainer> containers = new HashMap<>();
    private static final Map<String, NotificationResponse> pushAckContainer = new HashMap<>();
    private static final Map<String,NotificationResponse> deviceMessages = new ConcurrentHashMap<>();
    private static final Map<String, Consumer<NotificationResponse>> listeners=new ConcurrentHashMap<>();

    private final AmqpAdmin amqpAdmin;
    private final RabbitTemplate rabbitTemplate;
    private final ConnectionFactory connectionFactory;
    private Exchange exchange;

    public FCMCentralQueueService(AmqpAdmin amqpAdmin,RabbitTemplate rabbitTemplate,ConnectionFactory connectionFactory){
        this.amqpAdmin=amqpAdmin;
        this.rabbitTemplate=rabbitTemplate;
        this.connectionFactory=connectionFactory;
    }

    @PostConstruct
    public void init(){
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        exchange= ExchangeBuilder.directExchange("mobile-push").durable(true).build();
        amqpAdmin.declareExchange(exchange);
        declareAndBindQueue("push-sub-all",exchange,getQueueName("push-sub-all"));

    }

    private void declareAndBindQueue(String subscriptionId, Exchange exchange, String routingKey) {

        Queue queue = new Queue(getQueueName(subscriptionId),false,false,false);
        amqpAdmin.declareQueue(queue);
        amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(routingKey).noargs());
    }

    public void loadSubscriptionStatus(){

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueues(new Queue(getQueueName("push-sub-all"),false,true,false));
        container.setMessageListener(message -> {
            NotificationResponse notificationResponse;
            try {
                notificationResponse = new ObjectMapper().readValue(new String(message.getBody()),NotificationResponse.class);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if("stop".equalsIgnoreCase(notificationResponse.getType())){
                processStopSubscriptionRequest(notificationResponse);
            }
            try {
                deviceMessages.put(generateKey("subscription").substring(0,10),notificationResponse);

            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

            listeners.forEach((key,listener)->listener.accept(notificationResponse));
        });
        container.afterPropertiesSet();
        container.start();
    }

    public Flux<NotificationResponse> getSubscriptionResponseFlux(){
        String subscriptionId = generateKey("subscription").substring(0,10);
        final SubsNotificationEmitter<NotificationResponse> eventEmitter = new SubsNotificationEmitter<>(subscriptionId);
        return Flux.create(eventEmitter).doOnSubscribe(subscription -> {
            listeners.put(subscriptionId,eventEmitter::emit);
            NotificationResponse subscriptionResponse = deviceMessages.get(subscriptionId);
            if(subscriptionResponse !=null){
                if("sub".equalsIgnoreCase(subscriptionResponse.getType())){
                    subscriptionResponse.setType("auth");
                }
                eventEmitter.accept((FluxSink<NotificationResponse>) subscription);
                eventEmitter.emit(subscriptionResponse);
            }
        }).doOnNext(response -> {
            if(Objects.equals(response.getStatus(),"ok") && !Objects.equals("stop",response.getType())){
                String ackSubscriptionId = generateRoutingKey("ack",response.getDeviceId(),response.getDomain());
                declareAndBindQueue(subscriptionId,exchange,ackSubscriptionId);
            }
            deviceMessages.remove(subscriptionId);
        }).doOnComplete(()->{
            unBindSubscribedQueue(getQueueName("push-sub-all"),exchange);
            deviceMessages.remove(subscriptionId);
        }).doOnCancel(()->{
            unBindSubscribedQueue(getQueueName("push-sub-all"),exchange);
            deviceMessages.remove(subscriptionId);
        });
    }

    private String generateRoutingKey(String ack, String deviceId, String domain) {
        return ack+"|"+deviceId+"|"+domain;
    }

    public boolean checkQueue(String routingQueue){
        Properties properties = amqpAdmin.getQueueProperties(getQueueName(routingQueue));
        return properties!=null;
    }

    public ParallelFlux<NotificationResponse> getPushEvent(String subscriptionId){
        DefaultPushNotificationEmitter emitter = new DefaultPushNotificationEmitter(subscriptionId);
        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter();
        listenerAdapter.setDelegate(emitter);
        listenerAdapter.setDefaultListenerMethod("emit");
        listenerAdapter.setMessageConverter(new Jackson2JsonMessageConverter());
        String containerKey = getQueueName(subscriptionId);
        SimpleMessageListenerContainer simpleMessageListenerContainer = (SimpleMessageListenerContainer)containers.get(containerKey);
        if(simpleMessageListenerContainer == null){
            simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        }
        SimpleMessageListenerContainer finalContainer = simpleMessageListenerContainer;
        return Flux.create(emitter).doOnSubscribe(subscription -> {

            finalContainer.setShutdownTimeout(1);
            finalContainer.setConnectionFactory(connectionFactory);
            finalContainer.setMessageListener(listenerAdapter);
            containers.put(containerKey,finalContainer);

            finalContainer.setQueueNames(getQueueName(subscriptionId));
            finalContainer.setConcurrency(String.valueOf(10));
            finalContainer.setConcurrentConsumers(10);
            finalContainer.start();
        }).doOnCancel(()->{
            containers.get(containerKey).stop();
            containers.remove(containerKey);
        }).parallel(10).runOn(Schedulers.boundedElastic());
    }

    public void unBindSubscribedQueue(String subscriptionId,Exchange exchange){
        Queue queue = new Queue(getQueueName(subscriptionId));
        amqpAdmin.removeBinding(BindingBuilder.bind(queue).to(exchange).with("push-sub-all").noargs());
    }

    private String generateKey(String subscription) {
        return "";
    }

    private String getQueueName(String subscriptionId) {
        return String.join(".","subscription",subscriptionId);
    }
}
