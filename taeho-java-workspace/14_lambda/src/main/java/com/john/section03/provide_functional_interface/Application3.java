package com.john.section03.provide_functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

/*
    Function
    - 매개변수와 리턴 값이 있는 apply 메서드 조냊
    - 특정 값을 전달받아 특정 연산 후 반환해주는 역할, '전달값을 반환값으로 매핑해준다'라고도 함

    public interface Function<T, R> {
        R apply(T t);
    }
 */
public class Application3 {
    public static void main(String[] args) {
        
        // 1. Function<T, R> { R apply(T t) }: 전달된 객체 T를 R로 매핑해서 반환
        Function<String, Integer> fun = str -> Integer.parseInt(str);
        String strVal = "1234";
        System.out.println(fun.apply(strVal) + " : " + fun.apply(strVal).getClass().getName());
        
        // 2. BiFunction<T, U, R> { R apply(T t, U u)} : 전달된 객체 T와 U를 R로 매핑해서 반환
        BiFunction<String, String, Integer> biFunction
                = (str, str2) -> Integer.parseInt(str2);
        System.out.println(biFunction.apply("1234","567"));

        // 3. IntFunction<R> { R apply(Int value) }: 전달된 int 값을 R로 매핑해서 반환
        IntFunction<String> intFunction = num -> String.valueOf(num);
        System.out.println(intFunction.apply(123) + " : " + intFunction.apply(123).getClass().getName());

        System.out.println("===================");

        giveFunction(num -> num > 0.5);
    }

    public static void giveFunction(Function<Double, Boolean> function) {
        System.out.println(function.apply(Math.random()));
    }
}
