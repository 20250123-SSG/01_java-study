package com.ino.section03.provide_functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Application3 {
    public static void main(String[] args) {
        Function<Integer, Integer> func1 = num1 -> num1*num1;
        System.out.println(func1.apply(5));

        BiFunction<Integer, Integer, Integer> func2 = (n1, n2) -> n1+n2;
        System.out.println(func2.apply(15, 36));

        giveFunction( num -> num > 0.5);
    }

    public static void giveFunction(Function<Double, Boolean> function) {
        Boolean apply = function.apply(Math.random());
    }
}
