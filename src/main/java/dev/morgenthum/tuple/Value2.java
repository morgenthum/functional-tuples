package dev.morgenthum.tuple;

public interface Value2<T1, T2> extends Value1<T1> {

    T2 getValue2();

    default boolean isEmpty() {
        return Value1.super.isEmpty() && getValue2() == null;
    }

    default boolean isPresent() {
        return Value1.super.isPresent() && getValue2() != null;
    }

    default boolean isPartiallyPresent() {
        return !isEmpty() && !isPresent();
    }
}
