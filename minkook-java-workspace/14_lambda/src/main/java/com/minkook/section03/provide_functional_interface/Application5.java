package com.minkook.section03.provide_functional_interface;

import java.util.function.Predicate;

public class Application5 {
    public static void main(String [] args){
        /*
            ## java.util.

            public interface Predicate<T> {
                boolean test(T t);
            }
         */
        
        //1. predicate<T> {boolean test(T t) }; T를 조사하여 boolean 반환
        Predicate<Object> predicate = value -> value instanceof String;
        System.out.println("문자열인지 확인: " + predicate.test("123"));
        System.out.println("문자열인지 확인: " + predicate.test(123));

        Predicate<Integer> isEven = value -> value% 2 == 0;
        System.out.println("짝수인지 확인: " + isEven.test(5));

        System.out.println("===============================================");
        givenPredicate(name -> name.charAt(0) == '홍');

    }

    public static void givenPredicate(Predicate<String> predicate){
        System.out.println(predicate.test("홍길동"));
    }
}
