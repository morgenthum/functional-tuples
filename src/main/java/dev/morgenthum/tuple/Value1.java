package dev.morgenthum.tuple;

import dev.morgenthum.tuple.function.Consumer0;

public interface Value1<T1> {

    T1 getValue1();

    default boolean isEmpty() {
        return getValue1() == null;
    }

    default boolean isPresent() {
        return getValue1() != null;
    }

    default <E extends Exception> void ifEmpty(Consumer0<E> consumer) throws E {
        if (isEmpty()) {
            Exceptions.requireConsumer(consumer).accept();
        }
    }
}
