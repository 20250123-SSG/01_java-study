package com.john.section03.provide_functional_interface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/*
    - Supplier
    매개변수 없고 리턴 값이 있는 get method 존재
    특정 값을 반환하는 공급자 역할

    public interface Supplier<T>{
        T get();
    }
 */
public class Application2 {
    public static void main(String[] args) {
        
        // 1. Supplier<T> { T get() } : T타입의 객체를 반환
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());

        // 2. BooleanSupplier { boolean getAsBoolean() } : boolean 값을 반환
        BooleanSupplier booleanSupplier = () -> {
            int random = (int) (Math.random() * 2);
            return random == 0 ? true : false;
        };
        System.out.println("랜덤 true or False: " + booleanSupplier.getAsBoolean());

        // 3. IntSupplier { int getAsInt() } : int 값을 반환
        IntSupplier intSupplier = () -> (int) (Math.random() * 6 + 1);
        System.out.println("dice Number: " + intSupplier.getAsInt());

        System.out.println("====================");

        giveSupplier( () -> "아이고");
        giveSupplier( () -> "아이고난");
        giveSupplier( () -> "아이고난왜");
        giveSupplier( () -> {
            System.out.println("givSupplier method run");
            return "후";
        });


    }

    public static void giveSupplier(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
}
