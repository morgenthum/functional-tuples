package dev.morgenthum.tuple.function;

@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R, E extends Exception> {

    R apply(T1 t1, T2 t2, T3 t3, T4 t4) throws E;
}
