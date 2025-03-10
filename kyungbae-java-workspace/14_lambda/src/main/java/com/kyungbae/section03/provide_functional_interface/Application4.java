package com.kyungbae.section03.provide_functional_interface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Application4 {
    public static void main(String[] args) {

        // 1. UnaryOperator<T> { T apply(T t) } : 전달된 T타입의 객체를 T타입의 객체로 매핑해서 반환
        UnaryOperator<String> unaryOperator = str -> str + "world";
        System.out.println(unaryOperator.apply("hello "));

        // 2. BinaryOperator<T> { T apply(T t1, T t2) } : 전달된 T타입의 객체 두개를 연산해서 새로운 T타입의 객체로 매핑해서 반환
        BinaryOperator<String> binaryOperator = (str1, str2) -> str1+" "+str2;
        System.out.println(binaryOperator.apply("hello", "world"));

        System.out.println("----------------------------------");

        giveOperator( (num1, num2) -> num1 + num2 );
        giveOperator( (num1, num2) -> num1 - num2 );
        giveOperator( (num1, num2) -> num1 * num2 );
        giveOperator( (num1, num2) -> num1 / num2 );
        giveOperator( (num1, num2) -> num1 % num2 );

    }

    public static void giveOperator(BinaryOperator<Integer> binaryOperator){
        System.out.println(binaryOperator.apply(10,3));
    }

}
