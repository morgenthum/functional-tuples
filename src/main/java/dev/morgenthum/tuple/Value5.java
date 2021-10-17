package dev.morgenthum.tuple;

public interface Value5<T1, T2, T3, T4, T5> extends Value4<T1, T2, T3, T4> {

    T5 getValue5();

    default boolean isEmpty() {
        return Value4.super.isEmpty() && getValue5() == null;
    }

    default boolean isPresent() {
        return Value4.super.isPresent() && getValue5() != null;
    }
}
