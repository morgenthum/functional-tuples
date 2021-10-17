package dev.morgenthum.tuple.function;

@FunctionalInterface
public interface Consumer2<T1, T2, E extends Exception> {

    void accept(T1 t1, T2 t2) throws E;
}
