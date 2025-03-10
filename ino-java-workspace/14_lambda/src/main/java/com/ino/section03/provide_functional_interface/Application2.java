package com.ino.section03.provide_functional_interface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {
        Supplier<LocalDateTime> ldtS = () -> LocalDateTime.now();
        System.out.println(ldtS.get());

        BooleanSupplier booleanSupplier = () -> {
            int random = (int) (Math.random() * 2);
            return random == 0 ? false : true;
        };

        System.out.println(booleanSupplier.getAsBoolean());

        giveSupplier( () -> "hi it's ino");
    }

    public static void giveSupplier(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
}
