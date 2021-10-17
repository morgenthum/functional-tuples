package dev.morgenthum.tuple;

public interface Value3<T1, T2, T3> extends Value2<T1, T2> {

    T3 getValue3();

    default boolean isEmpty() {
        return Value2.super.isEmpty() && getValue3() == null;
    }

    default boolean isPresent() {
        return Value2.super.isPresent() && getValue3() != null;
    }
}
