package dev.morgenthum.tuple;

import dev.morgenthum.tuple.function.Consumer2;
import dev.morgenthum.tuple.function.Function1;
import dev.morgenthum.tuple.function.Function2;

import java.util.Objects;
import java.util.function.Predicate;

public class Tuple2<T1, T2> implements Value2<T1, T2> {

    public static <T1, T2> T1 first(T1 value1, T2 value2) {
        return value1;
    }

    public static <T1, T2> T2 last(T1 value1, T2 value2) {
        return value2;
    }

    private final T1 value1;
    private final T2 value2;

    Tuple2(T1 value1, T2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public <T3> Tuple3<T1, T2, T3> add(T3 value3) {
        return Tuple.of(value1, value2, value3);
    }

    public Tuple2<T2, T1> swap() {
        return Tuple.of(value2, value1);
    }

    public <R, E extends Exception> Tuple2<R, T2> map1(Function1<T1, R, E> function) throws E {
        R result = value1 == null ? null : Exceptions.requireFunction(function).apply(value1);
        return Tuple.of(result, value2);
    }

    public <R, E extends Exception> Tuple2<T1, R> map2(Function1<T2, R, E> function) throws E {
        R result = value2 == null ? null : Exceptions.requireFunction(function).apply(value2);
        return Tuple.of(value1, result);
    }

    public <R1, R2, E extends Exception> Tuple2<R1, R2> mapTuple(Function2<T1, T2, Tuple2<R1, R2>, E> function) throws E {
        return Exceptions.requireFunction(function).apply(value1, value2);
    }

    public <R1, E extends Exception> Tuple1<R1> fold(Function2<T1, T2, R1, E> function) throws E {
        return Tuple.of(Exceptions.requireFunction(function).apply(value1, value2));
    }

    public <T3, E extends Exception> Tuple3<T1, T2, T3> unfold(Function1<T2, T3, E> function) throws E {
        return unfoldBy(Tuple2::last, function);
    }

    public <TX, T3, E extends Exception> Tuple3<T1, T2, T3> unfoldBy(Function2<T1, T2, TX, E> selector, Function1<TX, T3, E> function) throws E {
        T3 value3 = null;
        TX selected = Exceptions.requireSelector(selector).apply(value1, value2);
        if (selected != null) {
            value3 = Exceptions.requireFunction(function).apply(selected);
        }
        return Tuple.of(value1, value2, value3);
    }

    public <E extends Exception> void ifPresent(Consumer2<T1, T2, E> consumer) throws E {
        ifPredicate(Value2::isPresent, consumer);
    }

    public <E extends Exception> void ifPartiallyPresent(Consumer2<T1, T2, E> consumer) throws E {
        ifPredicate(Value2::isPartiallyPresent, consumer);
    }

    public <E extends Exception> void ifPredicate(Predicate<Tuple2<T1, T2>> predicate, Consumer2<T1, T2, E> consumer) throws E {
        if (predicate.test(this)) {
            Exceptions.requireConsumer(consumer).accept(getValue1(), getValue2());
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
    public String toString() {
        return "Tuple{" +
            "value1=" + value1 +
            ", value2=" + value2 +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(value1, tuple2.value1) && Objects.equals(value2, tuple2.value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2);
    }
}
