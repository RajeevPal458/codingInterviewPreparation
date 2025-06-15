package code.curious.fcm.model;

import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class SubsNotificationEmitter<T> implements Consumer<FluxSink<T>> {
    private FluxSink<T> sink;
    private final String subscriptionId;
    public SubsNotificationEmitter(String subscriptionId){
        this.subscriptionId = subscriptionId;
    }
    @Override
    public void accept(FluxSink<T> fluxSink) {
        this.sink= fluxSink;
    }
    public void emit(NotificationResponse response){
        sink.next((T)response);
    }
}
