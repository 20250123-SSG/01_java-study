package com.minkook.section03.provide_functional_interface;

import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public class Application1 {
    /*
        ## 표준 함수형 인터페이스 ##
        1. JDK 8에서 빈번하게 사용되는 함수형 인터페이스를 표준 API로 제공하고 있음
        2. 주요 종류
            1) Consumer
            2) Supplier
            3) Function
            4) Opeartor
            5) Predicate
     */

    public static void main(String [] args){
        Consumer<String> consumer = str -> System.out.println(str + "이가 입력됨");
        consumer.accept("hello world");
        BiConsumer<String, LocalTime> biConsumer = (str,time) -> System.out.println(str + "이(가)" + time + "에 입력됨");
        biConsumer.accept("hello world",LocalTime.now());

        //3. IntConsumer
        IntConsumer intConsumer = num -> System.out.println("입력하신 정수의 제곱은 " + num*num + "입니다.");
        intConsumer.accept(2);

        DoubleConsumer doubleConsumer = num -> System.out.println("입력하신 실수는 " + num + "입니다.");
        doubleConsumer.accept(123.456);
    }
    
    //Consumer 객체를 요구하는 메소드
    // 해당 메소드에서는 주로 전달된 Consumer 객체를 통해 accpet 메소드 이용
    public static void giveConsumer(Consumer<String> consumer){
        consumer.accept("minkook");
    }




}
