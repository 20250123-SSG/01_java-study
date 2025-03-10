package com.seungjoo.section04.references;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {

        Function<Integer, Integer> function = Math::abs;
        System.out.println(function.apply(-5));

        //case2. 특정값을 전달받아 단지 출력만 해주는 Comsummer
        Consumer<Object> consumer = System.out::println;
        consumer.accept("hello world");
        consumer.accept(123);


//        list.forEach(System.out::println)

    }
}
