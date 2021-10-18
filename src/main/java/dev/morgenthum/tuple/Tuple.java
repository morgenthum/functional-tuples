package dev.morgenthum.tuple;

public class Tuple {

    public static <T1> Tuple1<T1> of(T1 value) {
        return new Tuple1<>(value);
    }

    public static <T1, T2> Tuple2<T1, T2> of(T1 value1, T2 value2) {
        return new Tuple2<>(value1, value2);
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 value1, T2 value2, T3 value3) {
        return new Tuple3<>(value1, value2, value3);
    }

    public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 value1, T2 value2, T3 value3, T4 value4) {
        return new Tuple4<>(value1, value2, value3, value4);
    }

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
        return new Tuple5<>(value1, value2, value3, value4, value5);
    }

    public static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> of(T1 value1, T2 value2, T3 value3, T4 value4,
                                                                             T5 value5, T6 value6) {
        return new Tuple6<>(value1, value2, value3, value4, value5, value6);
    }
}
