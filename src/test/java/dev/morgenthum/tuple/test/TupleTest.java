package dev.morgenthum.tuple.test;

import dev.morgenthum.tuple.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TupleTest {

    @Test
    public void testMapElements() {
        Tuple<Integer, String> tuple = Tuple.of("five", 1)
            .map1(s -> "five".equals(s) ? 5 : 0)
            .map2(i -> i == 1 ? "one" : "unknown");

        Assertions.assertEquals(Tuple.of(5, "one"), tuple);
    }
}
