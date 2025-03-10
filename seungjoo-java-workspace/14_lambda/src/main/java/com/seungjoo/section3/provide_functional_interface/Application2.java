package com.seungjoo.section3.provide_functional_interface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {
        //T타입의 객체를 반환
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get()
        );

        //BooleanSupplier
        BooleanSupplier boolSupplier = () -> {
            int random = (int) (Math.random() * 2);
            return random == 0 ? false : true;
        };
        System.out.println("랜덤 true or false" + boolSupplier.getAsBoolean());


        //3. IntSupplier
        IntSupplier intSupplier = () -> (int) (Math.random() * 6 + 1);
        System.out.println("주사위를 던져서 나온수: " + intSupplier.getAsInt());


    }
}