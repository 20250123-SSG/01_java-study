package com.ino.section04.references;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        Function<Integer, Integer> absFunc = Math::abs;
        System.out.println(absFunc.apply(-10));

        Consumer<Object> consumer = System.out::println;

        consumer.accept("Hello World");

        BiFunction<String, String, Boolean> biFunction = String::equals;

        System.out.println(biFunction.apply("ab", "ab"));

        Function<String, Account> stringAccountFunction = Account::new;

        Account ac1 = stringAccountFunction.apply("ino");
        ac1.setBalance(20000);
        Account ac2 = stringAccountFunction.apply("ino2");
        ac1.setBalance(20000);
        Account ac3 = stringAccountFunction.apply("ino3");
        ac1.setBalance(20000);

        List<Account> acList = new ArrayList<>();
        acList.add(ac1);
        acList.add(ac2);
        acList.add(ac3);

        acList.forEach(System.out::println);
    }
}
