package com.sotogito.section04.references;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Application {
    /**
     * ## 메서드 참조
     * 1. 함수형 인터페이스를 람다식이 아닌 일반 메서드를 참조시켜 선언
     * 2. 이미 존재하는 메서드를 참조하여 람다식에서 불필요한 매개변수 선언 제거
     * 3. 함수형 인터페이스의 매개변수, 반환타입과 참조할 메서드의 매개변수, 반환타입이 같아야함
     *
     * - 정적 메서드 참조 => 클래스명::staticMethodName
     * - 인터페이스 메서드 참조 => 참조변수::instanceMethodName
     * - 특정 타입의 객체 메서드 챀조 => 타입::methodName
     * - 생성자 참조 => 클래스명::name
     */


    public static void main(String[] args) {
        //1. 특정 정수값을 전달받아 절대값을 반환해주는 Function
        //Function<Integer, Integer> abs = number -> Math.abs(number);
        Function<Integer, Integer> abs = Math::abs;
        System.out.println(abs.apply(-1));

        //case2 특정 값을 전달받아 단지 출력만 해주는 Consumer
        //Consumer<Objects> consumer = obj -> System.out.println(obj);
        Consumer<Object> consumer = System.out::println;
        consumer.accept("ewf");
        consumer.accept(234);


        //3. 두개의 물자열을 전달받아 일치하는지 비교하여 boolean 반환해주는  BiFunction
        //BiFunction<String, String, Boolean> biFunc = (a,b) -> a.equals(b);
        BiFunction<String, String, Boolean> biFunc = String::equals;
        System.out.println(biFunc.apply("ewf", "ewf"));

        //4. 이름값을 전달받아 Account객체 생성 시 반환해두는 Function
        //Function<String,Account> accountFunction = name -> new Account(name);
        Function<String, Account> accountFunction = Account::new;
        Account acc = accountFunction.apply("ewf");
        Account acc2 = accountFunction.apply("e");

        acc.setBalance(5000);
        acc2.setBalance(5000);

        System.out.println("===================");
        List<Account> list = Arrays.asList(acc, acc2);
        list.forEach(account -> {
            if(account.getBalance() > 5000) {
                System.out.println(account);
            }
        });
        list.forEach(System.out::println);
    }
}
