package dev.morgenthum.tuple.function;

@FunctionalInterface
public interface Consumer1<T1, E extends Exception> {

    void accept(T1 t1) throws E;
}
