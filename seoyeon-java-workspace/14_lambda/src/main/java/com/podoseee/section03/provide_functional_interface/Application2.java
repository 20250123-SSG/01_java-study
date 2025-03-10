package com.podoseee.section03.provide_functional_interface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {
        /*
            ## java.util.function.Supplier ##
            매개변수 없고 리턴값이 있는 get 메소드 존재
            특정 값을 반환하는 공급자 역할

            public interface Supplier<T> {
                T get();
            }
         */

        // 1. Supplier<T> { T get() } : T타입의 객체를 반환
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());

        // 2. BooleanSupplier { boolean getAsBoolean() } : boolean 값을 반환
        BooleanSupplier boolSupplier = () -> {
            int random = (int)(Math.random() * 2); // 0 또는 1
            return random == 0 ? false : true;
        };
        System.out.println("랜덤 true or false: " + boolSupplier.getAsBoolean());

        // 3. IntSupplier { int getAsInt() } : int 값을 반환
        IntSupplier intSupplier = () -> (int)(Math.random() * 6 + 1);
        System.out.println("주사위를 던져서 나온수: " + intSupplier.getAsInt());

        System.out.println("=============================");

        giveSupplier( () -> "hello lambda");
        giveSupplier( () -> "hello everyone");
        giveSupplier( () -> {
            System.out.println("giveSupplier 메소드 동작됨");
            return "good bye";
        });

    }

    public static void giveSupplier(Supplier<String> supplier){
        System.out.println(supplier.get());
    }
}
