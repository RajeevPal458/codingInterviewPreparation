package code.curious.fcm.model;

import reactor.core.publisher.FluxSink;

public class DefaultPushNotificationEmitter<T> implements IPushNotificationEmitter<T>{

    private final String subscriptionId;
    private FluxSink<T> sink;

    public DefaultPushNotificationEmitter(String subscriptionId){
        this.subscriptionId = subscriptionId;
    }
    @Override
    public void emit(T event) {
        sink.next(event);
    }

    @Override
    public String getId() {
        return subscriptionId;
    }

    @Override
    public void accept(FluxSink<T> fluxSink) {
        this.sink = fluxSink;
    }
}
