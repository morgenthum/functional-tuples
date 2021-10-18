package dev.morgenthum.tuple;

import dev.morgenthum.tuple.function.Consumer1;
import dev.morgenthum.tuple.function.Function1;

import java.util.Objects;
import java.util.function.Predicate;

public class Tuple1<T1> implements Value1<T1> {

    public static <T1> T1 first(T1 value1) {
        return value1;
    }

    private final T1 value1;

    Tuple1(T1 value1) {
        this.value1 = value1;
    }

    public <T2> Tuple2<T1, T2> add(T2 value2) {
        return Tuple.of(value1, value2);
    }

    public <R, E extends Exception> Tuple1<R> map(Function1<T1, R, E> function) throws E {
        return map1(function);
    }

    public <R, E extends Exception> Tuple1<R> map1(Function1<T1, R, E> function) throws E {
        R result = value1 == null ? null : Exceptions.requireFunction(function).apply(value1);
        return Tuple.of(result);
    }

    public <R, E extends Exception> Tuple1<R> mapTuple(Function1<T1, Tuple1<R>, E> function) throws E {
        return Exceptions.requireFunction(function).apply(value1);
    }

    public <T2, E extends Exception> Tuple2<T1, T2> unfold(Function1<T1, T2, E> function) throws E {
        return unfoldBy(Tuple1::first, function);
    }

    public <TX, T2, E extends Exception> Tuple2<T1, T2> unfoldBy(Function1<T1, TX, E> selector, Function1<TX, T2, E> function) throws E {
        T2 value2 = null;
        TX selected = Exceptions.requireSelector(selector).apply(value1);
        if (selected != null) {
            value2 = Exceptions.requireFunction(function).apply(selected);
        }
        return Tuple.of(value1, value2);
    }

    public <E extends Exception> void ifPresent(Consumer1<T1, E> consumer) throws E {
        ifPredicate(Value1::isPresent, consumer);
    }

    public <E extends Exception> void ifPredicate(Predicate<Tuple1<T1>> predicate, Consumer1<T1, E> consumer) throws E {
        if (predicate.test(this)) {
            Exceptions.requireConsumer(consumer).accept(getValue1());
        }
    }

    @Override
    public T1 getValue1() {
        return value1;
    }

    @Override
    public String toString() {
        return "Unit{" +
            "value1=" + value1 +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple1<?> tuple1 = (Tuple1<?>) o;
        return Objects.equals(value1, tuple1.value1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1);
    }
}
