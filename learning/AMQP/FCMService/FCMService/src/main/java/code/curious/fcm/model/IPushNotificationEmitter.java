package code.curious.fcm.model;

import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public interface IPushNotificationEmitter<T> extends Consumer<FluxSink<T>> {
    void emit(final T event);
    String getId();
}
