package com.pch.section03.provide_functional_interface;

import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public class Application1 {
    /*
        ## 표준 함수형 인터페이스 ##
        1.  JDK 8에서 빈번하게 사용되는 함수형 인터페이스를 표준 API로 제공하고 있음
        2.  주요 종류
            1) Consumer
            2) Supplier
            3) Function
            4) Operator
            5) Predicate
     */
    public static void main(String[] args) {
       /*
            ## java.util.Consumer ##
            매개변수가 있고 리턴값이 없는 accept 메소드 존재
            전달된 인자값을 갖고 해당 값을 사용만 하는 소비자 역할

            public interface Consumer<T> {
                void accept(T t);
            }
        */

        // 1. Consumer<T> { void accept(T t) } : 객체 T 를 받아 사용
        Consumer<String> consumer = str -> System.out.println(str + "이(가) 입력됨");
        consumer.accept("hello world");

        // 2. BiConsumer<T, U) { void accept(T t, U u) } : 객체 T, U 를 받아 사용
        BiConsumer<String, LocalTime> biConsumer = (str, time) -> {
            System.out.println(str + "이(가) " + time + "시간에 입력됨");
        };
        biConsumer.accept("hello world", LocalTime.now());

        // 3. IntConsumer { void accept(int value) } : int값을 받아서 사용
        IntConsumer intConsumer = num -> System.out.println("입력하신 정수의 제곱은 " + num*num + " 입디다");
        intConsumer.accept(10);

        // 4. DoubleConsumer { void accept(double value) } : double 값을 받아 사용
        DoubleConsumer doubleConsumer = num -> System.out.println("입력하신 실수는 " + num + " 입니다.");
        doubleConsumer.accept(10.0);
    }
}
