package dev.morgenthum.tuple.function;

@FunctionalInterface
public interface Consumer3<T1, T2, T3, E extends Exception> {

    void accept(T1 t1, T2 t2, T3 t3) throws E;
}
