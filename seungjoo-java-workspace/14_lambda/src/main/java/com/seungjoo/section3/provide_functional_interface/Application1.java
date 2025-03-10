package com.seungjoo.section3.provide_functional_interface;

import javax.swing.plaf.IconUIResource;
import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public class Application1 {
    public static void main(String[] args) {

        Consumer<String> consumer = str -> System.out.println(str + "이 입력됨");
        consumer.accept("hello world");

        BiConsumer<String, LocalTime> biConsumer = (str, time) -> System.out.println(str + "이" + time + "에 입력됨");
        biConsumer.accept("hello world", LocalTime.now());

        IntConsumer intConsumer = num -> System.out.println("입력하신 정수의 제곱은 " + num * num + "입니다.");
        intConsumer.accept(2);

        DoubleConsumer doubleConsumer = num -> System.out.println("입력하신 실수는 " + num + "입니다.");
        doubleConsumer.accept(2.0);


        //Consumer 객체를 요구하는 메소드
        // 즉, 해당 실행되는 메소드 내에서 동작시키고자 하는 accepet의 구현 람다식을 전달하면 됨

        giveConsumer(msg -> System.out.println(msg + msg.length()));

        giveConsumer(name -> System.out.println(name + "님 환영합니다."));

    }

    public static void giveConsumer(Consumer<String> consumer){
            consumer.accept("seungJoo");
    }

    }
