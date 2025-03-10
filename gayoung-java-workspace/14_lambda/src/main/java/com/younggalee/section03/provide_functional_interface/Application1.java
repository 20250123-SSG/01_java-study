package com.younggalee.section03.provide_functional_interface;

import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public class Application1 {
    /*
    표준 함수형 인터페이스
    1. 자바 8버전부터 빈번하게 사용되는 함수형 인터페이스
     */

    public static void main(String[] args) {
        /*
        Consumer
        매개변수 있고 리턴값이 없는 accept 메소드 존재
        전달된 인자값을 가지고 해당 값을 사용하는 소비자 역할

        public interface Consummer<T>{
        void accept(T t);
        }
         */


        // 1. Consumer<T> { void accept(T t) } : 객체 T를 받아 사용
        Consumer<String> consumer = str -> System.out.println(str + "입력됨 ");
        consumer.accept("hello world");

        // 2. BiConsumer<T, U> { void accept(T t, U u) } : 객체 T,U를 받아 사용
        // U는 출력 타입 제네릭 파라미터
        BiConsumer<String, LocalTime> biConsumer = (str, time) -> System.out.println(str + "   " + time);
        biConsumer.accept("hello world", LocalTime.now());

        // 3. IntConsumer { void accept(int value) } : int 값을 받아 사용
        IntConsumer intConsumer = num -> System.out.println(num*num + "입니다.");
        intConsumer.accept(2);

        // 4. DoubleConsumer { void accept(double value) } : double값을 받아 사용
        DoubleConsumer doubleConsumer = num -> System.out.println(num);
        doubleConsumer.accept(123.456);

        // 즉, 해당 실행되는 메소드 내에서 동작시키고자 하는 accept의 구현 람다식을 전달하면됨
//        giveConsumer(consumer 구현객체 == accept메소드의 람다식);
        giveConsumer(msg -> System.out.println(msg + msg.length()));
    }

    //Consumer 객체를 요구하는 메소드
    // 해당 메소드에서는 주로 전달된  Consumer 객체를 통해 accept 메소드 이용

    public static void giveConsumer(Consumer<String> consumer){
        consumer.accept("young");
    }


}
