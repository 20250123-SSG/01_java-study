package com.john.section03.provide_functional_interface;

import java.util.function.Consumer;

public class Application1 {
    public static void main(String[] args) {
        
        // 실행되는 메서드 내에서 동작시키고자 하는 accept 의 구현 람다식을 전달
        // giveConsumber(Consumer 구현객체 == accept 메서드의 람다식);
        giveConsumber(msg -> System.out.println("메시지: " + msg + ", 길이: " + msg.length()));
        
        giveConsumber(name -> System.out.println(name + "님 환영"));
    }
    // Consumer를 인자로 받는 메서드는 주로 전달된 객체를 통해 accept 메서드 이용
    public static void giveConsumber(Consumer<String> consumer) {
        consumer.accept("aula");
    }
}
