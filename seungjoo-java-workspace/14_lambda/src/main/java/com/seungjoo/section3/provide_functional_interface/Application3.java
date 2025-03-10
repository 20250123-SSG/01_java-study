package com.seungjoo.section3.provide_functional_interface;

import java.sql.SQLOutput;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Application3 {
    public static void main(String[] args) {
        //전달된 객체 T를 R로 매핑해서 반환
        Function<String, Integer> function = str -> Integer.parseInt(str);
        String strValue = "12345";
        System.out.println(function.apply(strValue));

        //BiFunction<T,U,R>, 전달된 객체 T와 U를 R로 매핑해서 반환
        BiFunction<String,String,Integer> biFunction = (str1, str2) -> Integer.parseInt(str1)+ Integer.parseInt(str2);
        System.out.println(biFunction.apply("123","456"));
        //전달된 T타입의 객체를 T타입의 객체로 매핑해서 반환
        UnaryOperator<String> unaryOperator = str -> str + "world";
        System.out.println(unaryOperator.apply("hello"));

        //2.BinaryOperator<T>{ T apply(T t1, T t2)} : 전달된 T타입의 객체 2개를 연산해서 T타입의 객체로 매핑해서 반환
        BinaryOperator<String> binaryOperator = (str1, str2) -> str1+str2;
        System.out.println(binaryOperator.apply("hello", "world"));





    }
}
