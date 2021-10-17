package dev.morgenthum.tuple;

import dev.morgenthum.tuple.function.Consumer1;
import dev.morgenthum.tuple.function.Function1;
import dev.morgenthum.tuple.function.Function2;

import java.util.Objects;
import java.util.function.Predicate;

public class Unit<T1> implements Value1<T1> {

    public static <T1> Unit<T1> of(T1 value) {
        return new Unit<>(value);
    }

    public static <T1> T1 first(T1 value1) {
        return value1;
    }

    private final T1 value1;

    private Unit(T1 value1) {
        this.value1 = value1;
    }

    public <R1, E extends Exception> Unit<R1> map(Function1<T1, R1, E> function) throws E {
        return map1(function);
    }

    public <R1, E extends Exception> Unit<R1> map1(Function1<T1, R1, E> function) throws E {
        return Unit.of(Exceptions.requireFunction(function).apply(value1));
    }

    public <R1, E extends Exception> Unit<R1> mapTuple(Function1<T1, Unit<R1>, E> function) throws E {
        return Exceptions.requireFunction(function).apply(value1);
    }

    public <T2, E extends Exception> Tuple<T1, T2> unfold(Function1<T1, T2, E> function) throws E {
        return unfoldBy(Unit::first, function);
    }

    public <TX, T2, E extends Exception> Tuple<T1, T2> unfoldBy(Function1<T1, TX, E> selector, Function1<TX, T2, E> function) throws E {
        T2 value2 = null;
        TX selected = Exceptions.requireSelector(selector).apply(value1);
        if (selected != null) {
            value2 = Exceptions.requireFunction(function).apply(selected);
        }
        return Tuple.of(value1, value2);
    }

    public <E extends Exception> Unit<T1> ifPresent(Consumer1<T1, E> consumer) throws E {
        return ifPredicate(Value1::isPresent, consumer);
    }

    public <E extends Exception> Unit<T1> ifPredicate(Predicate<Unit<T1>> predicate, Consumer1<T1, E> consumer) throws E {
        if (predicate.test(this)) {
            Exceptions.requireConsumer(consumer).accept(getValue1());
        }
        return this;
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
        Unit<?> unit = (Unit<?>) o;
        return Objects.equals(value1, unit.value1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1);
    }
}
