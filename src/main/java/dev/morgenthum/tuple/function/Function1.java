package dev.morgenthum.tuple.function;

@FunctionalInterface
public interface Function1<T1, R, E extends Exception> {

    R apply(T1 t1) throws E;
}
