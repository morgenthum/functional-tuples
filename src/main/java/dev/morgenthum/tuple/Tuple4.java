package dev.morgenthum.tuple;

import dev.morgenthum.tuple.function.Consumer4;
import dev.morgenthum.tuple.function.Function1;
import dev.morgenthum.tuple.function.Function4;

import java.util.Objects;
import java.util.function.Predicate;

public class Tuple4<T1, T2, T3, T4> implements Value4<T1, T2, T3, T4> {

    public static <T1, T2, T3, T4> T1 first(T1 value1, T2 value2, T3 value3, T4 value4) {
        return value1;
    }

    public static <T1, T2, T3, T4> T4 last(T1 value1, T2 value2, T3 value3, T4 value4) {
        return value4;
    }

    private final T1 value1;
    private final T2 value2;
    private final T3 value3;
    private final T4 value4;

    Tuple4(T1 value1, T2 value2, T3 value3, T4 value4) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    public <T5> Tuple5<T1, T2, T3, T4, T5> add(T5 value5) {
        return Tuple.of(value1, value2, value3, value4, value5);
    }

    public <R, E extends Exception> Tuple4<R, T2, T3, T4> map1(Function1<T1, R, E> function) throws E {
        R result = value1 == null ? null : Exceptions.requireFunction(function).apply(value1);
        return Tuple.of(result, value2, value3, value4);
    }

    public <R, E extends Exception> Tuple4<T1, R, T3, T4> map2(Function1<T2, R, E> function) throws E {
        R result = value2 == null ? null : Exceptions.requireFunction(function).apply(value2);
        return Tuple.of(value1, result, value3, value4);
    }

    public <R, E extends Exception> Tuple4<T1, T2, R, T4> map3(Function1<T3, R, E> function) throws E {
        R result = value3 == null ? null : Exceptions.requireFunction(function).apply(value3);
        return Tuple.of(value1, value2, result, value4);
    }

    public <R, E extends Exception> Tuple4<T1, T2, T3, R> map4(Function1<T4, R, E> function) throws E {
        R result = value4 == null ? null : Exceptions.requireFunction(function).apply(value4);
        return Tuple.of(value1, value2, value3, result);
    }

    public <T5, E extends Exception> Tuple5<T1, T2, T3, T4, T5> unfold(Function1<T4, T5, E> function) throws E {
        return unfoldBy(Tuple4::last, function);
    }

    public <TX, T5, E extends Exception> Tuple5<T1, T2, T3, T4, T5> unfoldBy(Function4<T1, T2, T3, T4, TX, E> modifier,
                                                                             Function1<TX, T5, E> function) throws E {
        T5 value5 = null;
        TX temp = Exceptions.requireSelector(modifier).apply(value1, value2, value3, value4);
        if (temp != null) {
            value5 = Exceptions.requireFunction(function).apply(temp);
        }
        return Tuple.of(value1, value2, value3, value4, value5);
    }

    public <E extends Exception> void ifPresent(Consumer4<T1, T2, T3, T4, E> consumer) throws E {
        ifPredicate(Value4::isPresent, consumer);
    }

    public <E extends Exception> void ifPartiallyPresent(Consumer4<T1, T2, T3, T4, E> consumer) throws E {
        ifPredicate(Value2::isPartiallyPresent, consumer);
    }

    public <E extends Exception> void ifPredicate(Predicate<Tuple4<T1, T2, T3, T4>> predicate,
                                                                    Consumer4<T1, T2, T3, T4, E> consumer) throws E {
        if (predicate.test(this)) {
            Exceptions.requireConsumer(consumer).accept(getValue1(), getValue2(), getValue3(), getValue4());
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
    public String toString() {
        return "Tuple4{" +
            "value1=" + value1 +
            ", value2=" + value2 +
            ", value3=" + value3 +
            ", value4=" + value4 +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple4<?, ?, ?, ?> tuple4 = (Tuple4<?, ?, ?, ?>) o;
        return Objects.equals(value1, tuple4.value1) && Objects.equals(value2, tuple4.value2) && Objects.equals(value3, tuple4.value3) && Objects.equals(value4, tuple4.value4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2, value3, value4);
    }
}
