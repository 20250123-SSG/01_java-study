package com.kyungbae.section03.provide_functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Application3 {
    public static void main(String[] args) {

        // 1. Function<T, R> { R apply(T t) } : 전달된 객체 T를 R로 매핑해서 반환
        Function<String, Integer> function = str -> Integer.parseInt(str);
        String strValue = "12345";
        System.out.println(function.apply(strValue)+ " : " + function.apply(strValue).getClass().getName());

        // 2. BiFunction<T, U, R> { R apply(T t, U u) } : 전달된 객체 T와 U를 R로 매핑해서 반환
        BiFunction<String, String, Integer> biFunction = (str1, str2) ->
            Integer.parseInt(str1) + Integer.parseInt(str2);
        System.out.println(biFunction.apply("12345", "67890"));

        // 3. IntFunction<R> { R apply(int value) } : 전달된 int값을 R로 매핑해서 반환
        IntFunction<String> intFunction = num -> String.valueOf(num);
        System.out.println(intFunction.apply(123) + " : " + intFunction.apply(123).getClass().getName());

        System.out.println("---------------------------------");

        giveFunction( num -> num > 0.5 );

    }

    public static void giveFunction(Function<Double, Boolean> function){
        System.out.println(function.apply(Math.random()));
    }
}
