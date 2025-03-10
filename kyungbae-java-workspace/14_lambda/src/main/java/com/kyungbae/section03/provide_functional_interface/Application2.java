package com.kyungbae.section03.provide_functional_interface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {

        // 1. Supplicer<T> {T get()} : T타입의 객체를 반환
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());

        // 2. BooleanSupplier { boolean getAsBoolean() } : boolean 값을 반환
        BooleanSupplier booleanSupplier = () -> {
            int random = (int)(Math.random() * 2);
            return random != 0;
        };
        System.out.println("랜덤 true or false: " + booleanSupplier.getAsBoolean());

        // 3. IntSupplier { int getAsInt() } : int 값을 반환
        IntSupplier intSupplier = () ->  (int)(Math.random() * 6 + 1);
        System.out.println("주사위: " + intSupplier.getAsInt());

        System.out.println("----------------------------------");

        giveSupplier(() -> "hello lambda");
        giveSupplier(() -> "hello everyone");
        giveSupplier(() -> {
            System.out.println("giveSupplier 동작됨");
            return "goodbye";
        });

    }

    public static void giveSupplier (Supplier<String> supplier){
        System.out.println(supplier.get());
    }
}
