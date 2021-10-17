package dev.morgenthum.tuple;

import dev.morgenthum.tuple.function.Consumer3;
import dev.morgenthum.tuple.function.Function1;
import dev.morgenthum.tuple.function.Function3;

import java.util.Objects;
import java.util.function.Predicate;

public class Tuple3<T1, T2, T3> implements Value3<T1, T2, T3> {

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 value1, T2 value2, T3 value3) {
        return new Tuple3<>(value1, value2, value3);
    }

    public static <T1, T2, T3> T1 first(T1 value1, T2 value2, T3 value3) {
        return value1;
    }

    public static <T1, T2, T3> T3 last(T1 value1, T2 value2, T3 value3) {
        return value3;
    }

    private final T1 value1;
    private final T2 value2;
    private final T3 value3;

    private Tuple3(T1 value1, T2 value2, T3 value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public <R, E extends Exception> Tuple3<R, T2, T3> map1(Function1<T1, R, E> function) throws E {
        R result = value1 == null ? null : Exceptions.requireFunction(function).apply(value1);
        return Tuple3.of(result, value2, value3);
    }

    public <R, E extends Exception> Tuple3<T1, R, T3> map2(Function1<T2, R, E> function) throws E {
        R result = value2 == null ? null : Exceptions.requireFunction(function).apply(value2);
        return Tuple3.of(value1, result, value3);
    }

    public <R, E extends Exception> Tuple3<T1, T2, R> map3(Function1<T3, R, E> function) throws E {
        R result = value3 == null ? null : Exceptions.requireFunction(function).apply(value3);
        return Tuple3.of(value1, value2, result);
    }

    public <T4, E extends Exception> Tuple4<T1, T2, T3, T4> unfold(Function1<T3, T4, E> function) throws E {
        return unfoldBy(Tuple3::last, function);
    }

    public <TX, T4, E extends Exception> Tuple4<T1, T2, T3, T4> unfoldBy(Function3<T1, T2, T3, TX, E> modifier, Function1<TX, T4, E> function) throws E {
        T4 value4 = null;
        TX temp = Exceptions.requireSelector(modifier).apply(value1, value2, value3);
        if (temp != null) {
            value4 = Exceptions.requireFunction(function).apply(temp);
        }
        return Tuple4.of(value1, value2, value3, value4);
    }

    public <E extends Exception> Tuple3<T1, T2, T3> ifPresent(Consumer3<T1, T2, T3, E> consumer) throws E {
        return ifPredicate(Value3::isPresent, consumer);
    }

    public <E extends Exception> Tuple3<T1, T2, T3> ifPartiallyPresent(Consumer3<T1, T2, T3, E> consumer) throws E {
        return ifPredicate(Value2::isPartiallyPresent, consumer);
    }

    public <E extends Exception> Tuple3<T1, T2, T3> ifPredicate(Predicate<Tuple3<T1, T2, T3>> predicate, Consumer3<T1, T2, T3, E> consumer) throws E {
        if (predicate.test(this)) {
            Exceptions.requireConsumer(consumer).accept(getValue1(), getValue2(), getValue3());
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
    public String toString() {
        return "Tuple3{" +
            "value1=" + value1 +
            ", value2=" + value2 +
            ", value3=" + value3 +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(value1, tuple3.value1) && Objects.equals(value2, tuple3.value2) && Objects.equals(value3, tuple3.value3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2, value3);
    }
}
