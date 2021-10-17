package dev.morgenthum.tuple.test;

import dev.morgenthum.tuple.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ExceptionTest {

    @Test
    public void testThrowChecked() {
        Assertions.assertThrows(IOException.class, () -> {
            Unit.of(null).ifEmpty(() -> {
                throw new IOException();
            });
        });
    }
}
