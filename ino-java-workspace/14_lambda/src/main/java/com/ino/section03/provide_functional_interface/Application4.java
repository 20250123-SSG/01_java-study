package com.ino.section03.provide_functional_interface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Application4 {
    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = str -> str + "world";

        unaryOperator.apply("hello ");

        BinaryOperator<String> binaryOperator = (s, s2) -> s + s2;

        System.out.println(binaryOperator.apply("hi" , "ino"));

        giveOperator( (x, y) -> x+y);
    }

    public static void giveOperator(BinaryOperator<Integer> operator) {
        System.out.println(operator.apply(10, 3));
    }
}
