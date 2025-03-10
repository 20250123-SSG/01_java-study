package com.john.section03.provide_functional_interface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/*
    ## XXXOperator
    - 매개변수와 리턴값이 있는 apply 메서드 존재
    - Function과 유사하나 반환값을 전달값과 동일한 타입으로 반환해주는 것이 다름
    public interface XXXOperator<T>{
        T apply(T t);
    }
 */
public class Application4 {
    public static void main(String[] args) {
    
        // 1.UnaryOperator<T> { T apply(T t) } : 전달된 T타입의 객체를 T타입의 객체로 매핑해서 반환
        UnaryOperator<String> unaryOperator = str -> str + "world";
        System.out.println(unaryOperator.apply("hello"));

        // 2. BinaryOperator<T> { T apply(T t1, T t2) } : 전달된 T타입의 객체 두개를 연산해서 T타입의 객체로 매핑해서 반환
        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("hello", "world"));

        System.out.println("==================================");

        giveOperator((x, y) -> x + y);
        giveOperator((x, y) -> x - y);
        giveOperator((x, y) -> x * y);
        giveOperator((x, y) -> x / y);
        giveOperator((x, y) -> x % y);
    }
    public static void giveOperator(BinaryOperator<Integer> operator) {
        System.out.println(operator.apply(10, 3));
    }
}
