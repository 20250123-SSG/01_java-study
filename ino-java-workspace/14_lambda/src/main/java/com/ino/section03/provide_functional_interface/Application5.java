package com.ino.section03.provide_functional_interface;

import java.util.Objects;
import java.util.function.Predicate;

public class Application5 {
    public static void main(String[] args) {
        Predicate<Object> predicate = value -> value instanceof String;
        System.out.println(predicate.test("123"));
        System.out.println(predicate.test(123));
    }
}
