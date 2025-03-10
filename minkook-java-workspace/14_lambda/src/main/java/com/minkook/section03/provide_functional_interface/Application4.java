package com.minkook.section03.provide_functional_interface;



import java.util.SortedMap;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Application4 {
    public static void main(String[]args){
        /*
            ##  java.util.function.XXXOperator ##
            매개변수와 리턴값이 있는 apply 메소드 존재
         */

        UnaryOperator<String> unaryOperator = str -> str + "world";
        System.out.println(unaryOperator.apply("hello"));

        // 2.BinaryOperator<T>
        BinaryOperator<String> binaryOperator = (str1,str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("hello","world"));
        System.out.println("=======================================");

        giveOperator((x,y) -> x + y);
        giveOperator((x,y) -> x - y);
        giveOperator((x,y) -> x * y);
        giveOperator((x,y) -> x / y);
        giveOperator((x,y) -> x  % y);

    }
    public static void giveOperator(BinaryOperator<Integer> operator){
        System.out.println(operator.apply(10,3));
    }
}
