package com.john.section03.provide_functional_interface;

import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

/*
    표준 함수형 인터페이스
    - Consumer
    - Supplier
    - Function
    - Operator
    - Predicate
 */
public class Application {
    public static void main(String[] args) {

    /*
        Consumer
        - 매개변수가 있고 리턴 값이 없는 accept 메서드가 존재
        - 전달된 인자값을 가지고 해당 값을 사용만 하는 소비자 역할
     */
        // 1. Consumer<T> { void accpt(T t)} : 객체 T를 받아 사용
        Consumer<String> consumer = str -> System.out.println(str + " 이 여기에 입력");
        consumer.accept("hello world");
        
        // 2. BiConsumer<T, U> { void accept(T t, U u) }: 객체 T,U를 받아 사용
        BiConsumer<String, LocalTime> biConsumer =
                (str, time) -> System.out.println(str + " 이(가) " + time + " 에 입력됨");

        biConsumer.accept("hello world", LocalTime.now());
        
        
        // 3. IntConsumer { void accept(int value) } : int 값을 받아 사용
        IntConsumer intConsumer = num -> System.out.println("입력하신 정수의 제곱은 " + num*num);
        intConsumer.accept(2);

        // 4. DoubleConsumer { void accept(double vlaue) } : double값을 받아서 사용
        DoubleConsumer doubleConsumer = num -> System.out.println("입력하신 실수는 " + num);
        doubleConsumer.accept(2.5);
    }
}
