package dev.morgenthum.tuple.function;

@FunctionalInterface
public interface Function0<R, E extends Exception> {

    R apply() throws E;
}
