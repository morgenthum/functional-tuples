package dev.morgenthum.tuple;

import dev.morgenthum.tuple.function.Consumer6;
import dev.morgenthum.tuple.function.Function1;

import java.util.Objects;
import java.util.function.Predicate;

public class Tuple6<T1, T2, T3, T4, T5, T6> implements Value6<T1, T2, T3, T4, T5, T6> {

    public static <T1, T2, T3, T4, T5, T6> T1 first(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5, T6 value6) {
        return value1;
    }

    public static <T1, T2, T3, T4, T5, T6> T6 last(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5, T6 value6) {
        return value6;
    }

    private final T1 value1;
    private final T2 value2;
    private final T3 value3;
    private final T4 value4;
    private final T5 value5;
    private final T6 value6;

    Tuple6(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5, T6 value6) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.value6 = value6;
    }

    public <R, E extends Exception> Tuple6<R, T2, T3, T4, T5, T6> map1(Function1<T1, R, E> function) throws E {
        R result = value1 == null ? null : Exceptions.requireFunction(function).apply(value1);
        return Tuple.of(result, value2, value3, value4, value5, value6);
    }

    public <R, E extends Exception> Tuple6<T1, R, T3, T4, T5, T6> map2(Function1<T2, R, E> function) throws E {
        R result = value2 == null ? null : Exceptions.requireFunction(function).apply(value2);
        return Tuple.of(value1, result, value3, value4, value5, value6);
    }

    public <R, E extends Exception> Tuple6<T1, T2, R, T4, T5, T6> map3(Function1<T3, R, E> function) throws E {
        R result = value3 == null ? null : Exceptions.requireFunction(function).apply(value3);
        return Tuple.of(value1, value2, result, value4, value5, value6);
    }

    public <R, E extends Exception> Tuple6<T1, T2, T3, R, T5, T6> map4(Function1<T4, R, E> function) throws E {
        R result = value4 == null ? null : Exceptions.requireFunction(function).apply(value4);
        return Tuple.of(value1, value2, value3, result, value5, value6);
    }

    public <R, E extends Exception> Tuple6<T1, T2, T3, T4, R, T6> map5(Function1<T5, R, E> function) throws E {
        R result = value5 == null ? null : Exceptions.requireFunction(function).apply(value5);
        return Tuple.of(value1, value2, value3, value4, result, value6);
    }

    public <R, E extends Exception> Tuple6<T1, T2, T3, T4, T5, R> map6(Function1<T6, R, E> function) throws E {
        R result = value6 == null ? null : Exceptions.requireFunction(function).apply(value6);
        return Tuple.of(value1, value2, value3, value4, value5, result);
    }

    public <E extends Exception> void ifPresent(Consumer6<T1, T2, T3, T4, T5, T6, E> consumer) throws E {
        ifPredicate(Value5::isPresent, consumer);
    }

    public <E extends Exception> void ifPartiallyPresent(Consumer6<T1, T2, T3, T4, T5, T6, E> consumer) throws E {
        ifPredicate(Value2::isPartiallyPresent, consumer);
    }

    public <E extends Exception> void ifPredicate(Predicate<Tuple6<T1, T2, T3, T4, T5, T6>> predicate,
                                                                            Consumer6<T1, T2, T3, T4, T5, T6, E> consumer) throws E {
        if (predicate.test(this)) {
            Exceptions.requireConsumer(consumer).accept(getValue1(), getValue2(), getValue3(), getValue4(), getValue5(), getValue6());
        }
    }

    @Override
    public T1 getValue1() {
        return value1;
    }

    @Override
    public T2 getValue2() {
        return value2;
    }

    @Override
    public T3 getValue3() {
        return value3;
    }

    @Override
    public T4 getValue4() {
        return value4;
    }

    @Override
    public T5 getValue5() {
        return value5;
    }

    @Override
    public T6 getValue6() {
        return value6;
    }

    @Override
    public String toString() {
        return "Tuple6{" +
            "value1=" + value1 +
            ", value2=" + value2 +
            ", value3=" + value3 +
            ", value4=" + value4 +
            ", value5=" + value5 +
            ", value6=" + value6 +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple6<?, ?, ?, ?, ?, ?> tuple6 = (Tuple6<?, ?, ?, ?, ?, ?>) o;
        return Objects.equals(value1, tuple6.value1) && Objects.equals(value2, tuple6.value2) && Objects.equals(value3, tuple6.value3) && Objects.equals(value4, tuple6.value4) && Objects.equals(value5, tuple6.value5) && Objects.equals(value6, tuple6.value6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2, value3, value4, value5, value6);
    }
}
