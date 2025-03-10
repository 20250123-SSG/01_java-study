package com.younggalee.section03.provide_functional_interface;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Application2 {

    /*

    java.util.function.Supperlier
    매개변수 없고 리턴값이 있는 get 메소드 존재
    특정 값을 반환하는 공급자 역할
    public interface Suppelier<T>{
        T get();
    }
     */
    public static void main(String[] args) {
        //1. Supplier<T> { T get() } : T타입의 객체를 반환
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());


        //2. booleanSupplier { boolean getAsBoolean() } : boolean 값을 반환
        BooleanSupplier boolSupplier = () -> {
            int random = (int) (Math.random() * 2); // 0 또는 1
            return random == 0 ? false : true;
        };
        System.out.println(boolSupplier.getAsBoolean());


        //3. IntSupplier : int 값을 반환
        IntSupplier intSupplier = () -> (int) (Math.random() * 6 + 1);
        System.out.println(intSupplier.getAsInt());

        giveSupplier( () -> "Hello lambda");
        giveSupplier( () -> "Hello everyone");

    }

    public static void giveSupplier(Supplier<String> supplier){
        System.out.println(supplier.get());
    }

}
