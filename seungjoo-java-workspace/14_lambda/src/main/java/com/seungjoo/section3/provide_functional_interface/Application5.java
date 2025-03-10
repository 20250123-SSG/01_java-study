package com.seungjoo.section3.provide_functional_interface;

import java.util.function.Predicate;

public class Application5 {
    public static void main(String[] args) {

        //1.Predicate<T> : T를 조사하여 boolean을 반환
        Predicate<Object> predicate = value -> value instanceof String;
        System.out.println(predicate.test("123"));
        System.out.println(predicate.test(123));

        Predicate<Integer> isEven = value -> value % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));

        System.out.println("====================");




    }
    public static void givePredicate(Predicate<String> predicate) {
        System.out.println(predicate.test("홍길동"));
    }
}
