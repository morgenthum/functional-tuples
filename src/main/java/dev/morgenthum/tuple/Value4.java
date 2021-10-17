package dev.morgenthum.tuple;

public interface Value4<T1, T2, T3, T4> extends Value3<T1, T2, T3> {

    T4 getValue4();

    default boolean isEmpty() {
        return Value3.super.isEmpty() && getValue4() == null;
    }

    default boolean isPresent() {
        return Value3.super.isPresent() && getValue4() != null;
    }
}
