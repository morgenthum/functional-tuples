package dev.morgenthum.tuple.function;

@FunctionalInterface
public interface Function6<T1, T2, T3, T4, T5, T6, R, E extends Exception> {

    R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) throws E;
}