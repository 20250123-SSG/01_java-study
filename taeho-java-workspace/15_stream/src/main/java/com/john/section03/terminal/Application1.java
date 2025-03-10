package com.john.section03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/*
    # Stream 가공
 */
public class Application1 {
    public static void main(String[] args) {
        // Calculating
        long count = IntStream.range(0, 10).count(); // 개수 반환 (default 0)

        int sum = IntStream.range(0, 10).sum(); // 합 반환 (default 0)

        OptionalInt max = IntStream.range(0, 10).max(); // 최대값 반환
        OptionalInt min = IntStream.range(0, 10).min();
        System.out.println(max);
        System.out.println(max.getAsInt());
        System.out.println(min);
        System.out.println(min.getAsInt());

        int sum2 = IntStream.rangeClosed(0, 10).filter(i -> i % 2 == 0).sum();
        System.out.println(sum2);


    }
}
