package dev.morgenthum.tuple;

import dev.morgenthum.tuple.function.Consumer5;
import dev.morgenthum.tuple.function.Function1;
import dev.morgenthum.tuple.function.Function5;

import java.util.Objects;
import java.util.function.Predicate;

public class Tuple5<T1, T2, T3, T4, T5> implements Value5<T1, T2, T3, T4, T5> {

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
        return new Tuple5<>(value1, value2, value3, value4, value5);
    }

    public static <T1, T2, T3, T4, T5> T1 first(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
        return value1;
    }

    public static <T1, T2, T3, T4, T5> T5 last(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
        return value5;
    }

    private final T1 value1;
    private final T2 value2;
    private final T3 value3;
    private final T4 value4;
    private final T5 value5;

    private Tuple5(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
    }

    public <R, E extends Exception> Tuple5<R, T2, T3, T4, T5> map1(Function1<T1, R, E> function) throws E {
        R result = value1 == null ? null : Exceptions.requireFunction(function).apply(value1);
        return Tuple5.of(result, value2, value3, value4, value5);
    }

    public <R, E extends Exception> Tuple5<T1, R, T3, T4, T5> map2(Function1<T2, R, E> function) throws E {
        R result = value2 == null ? null : Exceptions.requireFunction(function).apply(value2);
        return Tuple5.of(value1, result, value3, value4, value5);
    }

    public <R, E extends Exception> Tuple5<T1, T2, R, T4, T5> map3(Function1<T3, R, E> function) throws E {
        R result = value3 == null ? null : Exceptions.requireFunction(function).apply(value3);
        return Tuple5.of(value1, value2, result, value4, value5);
    }

    public <R, E extends Exception> Tuple5<T1, T2, T3, R, T5> map4(Function1<T4, R, E> function) throws E {
        R result = value4 == null ? null : Exceptions.requireFunction(function).apply(value4);
        return Tuple5.of(value1, value2, value3, result, value5);
    }

    public <R, E extends Exception> Tuple5<T1, T2, T3, T4, R> map5(Function1<T5, R, E> function) throws E {
        R result = value5 == null ? null : Exceptions.requireFunction(function).apply(value5);
        return Tuple5.of(value1, value2, value3, value4, result);
    }

    public <TX, T6, E extends Exception> Tuple6<T1, T2, T3, T4, T5, T6> unfoldBy(Function5<T1, T2, T3, T4, T5, TX, E> modifier,
                                                                                 Function1<TX, T6, E> function) throws E {
        T6 value6 = null;
        TX temp = Exceptions.requireSelector(modifier).apply(value1, value2, value3, value4, value5);
        if (temp != null) {
            value6 = Exceptions.requireFunction(function).apply(temp);
        }
        return Tuple6.of(value1, value2, value3, value4, value5, value6);
    }

    public <E extends Exception> Tuple5<T1, T2, T3, T4, T5> ifPresent(Consumer5<T1, T2, T3, T4, T5, E> consumer) throws E {
        return ifPredicate(Value5::isPresent, consumer);
    }

    public <E extends Exception> Tuple5<T1, T2, T3, T4, T5> ifPartiallyPresent(Consumer5<T1, T2, T3, T4, T5, E> consumer) throws E {
        return ifPredicate(Value2::isPartiallyPresent, consumer);
    }

    public <E extends Exception> Tuple5<T1, T2, T3, T4, T5> ifPredicate(Predicate<Tuple5<T1, T2, T3, T4, T5>> predicate,
                                                                        Consumer5<T1, T2, T3, T4, T5, E> consumer) throws E {
        if (predicate.test(this)) {
            Exceptions.requireConsumer(consumer).accept(getValue1(), getValue2(), getValue3(), getValue4(), getValue5());
        }
        return this;
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
    public String toString() {
        return "Tuple5{" +
            "value1=" + value1 +
            ", value2=" + value2 +
            ", value3=" + value3 +
            ", value4=" + value4 +
            ", value5=" + value5 +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple5<?, ?, ?, ?, ?> tuple5 = (Tuple5<?, ?, ?, ?, ?>) o;
        return Objects.equals(value1, tuple5.value1) && Objects.equals(value2, tuple5.value2) && Objects.equals(value3, tuple5.value3) && Objects.equals(value4, tuple5.value4) && Objects.equals(value5, tuple5.value5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2, value3, value4, value5);
    }
}
