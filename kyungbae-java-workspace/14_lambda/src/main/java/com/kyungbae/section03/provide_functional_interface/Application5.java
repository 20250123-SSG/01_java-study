package com.kyungbae.section03.provide_functional_interface;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Application5 {
    public static void main(String[] args) {

        // 1. Predicate<T> { boolean(T t) } : T를 조사하여 boolean을 반환
        Predicate<Object> predicate = value -> value instanceof String;
        System.out.println("문자열인지 확인: " + predicate.test("123"));
        System.out.println("문자열인지 확인: " + predicate.test(123));

        Predicate<Integer> isEven = value -> value % 2 == 0;
        System.out.println("짝수인지 " + isEven.test(2));

        givePredicate(value -> value.startsWith("홍"));

    }

    public static void givePredicate(Predicate<String> predicate){
        System.out.println(predicate.test("홍길동"));
    }
}
