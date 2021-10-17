package dev.morgenthum.tuple;

import java.util.Objects;

public class Exceptions {

    public static <T> T requireConsumer(T consumer) {
        return Objects.requireNonNull(consumer, "consumer must not be null");
    }

    public static <T> T requireFunction(T function) {
        return Objects.requireNonNull(function, "function must not be null");
    }

    public static <T> T requireSelector(T selector) {
        return Objects.requireNonNull(selector, "selector must not be null");
    }
}
