package dev.morgenthum.tuple.test;

import dev.morgenthum.tuple.Tuple;
import dev.morgenthum.tuple.Tuple1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ExceptionTest {

    @Test
    public void testThrowChecked() {
        Assertions.assertThrows(IOException.class, () -> {
            Tuple.of(null).ifEmpty(() -> {
                throw new IOException();
            });
        });
    }
}
