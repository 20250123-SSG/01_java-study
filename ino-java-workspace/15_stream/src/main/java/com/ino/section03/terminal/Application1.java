package com.ino.section03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {
        OptionalInt max = IntStream.range(1, 10).max();
        System.out.println(max.getAsInt());

        int sum = IntStream.rangeClosed(1, 10).filter(num -> num%2 == 0).sum();
        System.out.println("sum val : " + sum);


    }
}
