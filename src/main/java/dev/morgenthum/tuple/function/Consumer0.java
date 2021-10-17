package dev.morgenthum.tuple.function;

@FunctionalInterface
public interface Consumer0<E extends Exception> {

    void accept() throws E;
}
