package com.ino.section03.provide_functional_interface;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Application1 {
    public static void main(String[] args) {
        Consumer<String> cs = str -> System.out.println(str + "is input");
        cs.accept("hello world");

        BiConsumer<String, LocalTime> bcs = ((s, localTime) -> System.out.println(s + "is" + localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "input"));
        bcs.accept("hi", LocalTime.now());

        IntConsumer intConsumer = num -> System.out.println("num's pow = " + num*num);
        intConsumer.accept(5);

        giveConsumer(cs);
    }


    public static void giveConsumer(Consumer<String> consumer) {
        consumer.accept("ino");
    }
}

