package dev.morgenthum.tuple;

public interface Value6<T1, T2, T3, T4, T5, T6> extends Value5<T1, T2, T3, T4, T5> {

    T6 getValue6();

    default boolean isEmpty() {
        return Value5.super.isEmpty() && getValue6() == null;
    }

    default boolean isPresent() {
        return Value5.super.isPresent() && getValue6() != null;
    }
}
