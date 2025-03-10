package com.john.section04.references;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/*
    메서드 참조
    1. 함수형 인터페이스를 람다식이 아닌 일반 메서드를 참조시켜 선언하는 방법
    2. 이미 존재하는 메서드를 참조하여 람다식에서 불필요한 매개변수 선언을 제거할 수 있음
    3. 함수형 인터페이스의 매개변수, 반환타입과 참조할 메서드의 매개변수, 반횐타입이 같아야함
    4. 표현식
        4.1. 정적 메서드 참조       -> 클래스명::staticMethodName
        4.2. 인스턴스 메서드 참조    -> 참조변수::instanceMethodName
        4.3. 특정 타입의 객체 메서드 참조 -> 타입::methodName
        4.4. 생성자 참조            -> 클래스명::new

 */
public class Application {
    public static void main(String[] args) {

        // case1: 특정 정수값을 전달받아 절대값을 반환해주는 func.
//        Function<Integer, Integer> function = num -> Math.abs(num); // lambda
        Function<Integer, Integer> function = Math::abs;
        System.out.println(function.apply(-2));


        // case2: 특정값을 전달받아 단지 출력만해주는 Consumer
//        Consumer<Object> consumer = obj -> System.out.println(obj); // 전달값 가지고 sout 메서드에 전달
        Consumer<Object> consumer = System.out::println;
        consumer.accept("hello world");
        consumer.accept(1823);

        // case3: 두 개의 문자열을 전달받아 일치하는지 비교 후 boolean 반환 BiFunction
        // 첫번째 전달값(String 타입의 인스턴스)의 equals 메서드 실행
//        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> biFunction = String::equals;
        System.out.println(biFunction.apply("hello", "world"));
        System.out.println(biFunction.apply("hello", "hello"));

        // case4: 이름값을 전달받아 Account 객체를 생성 후 반환해주는 function
        // 전달값을 가지고 매개변수 생성자를 통해 객체 생성 후 반환
//        Function<String, Account> function2 = name -> new Account(name);
        Function<String, Account> function2 = Account::new;

        Account account = function2.apply("오오김성회");
        Account account2 = function2.apply("박성회");
        System.out.println(account);
        System.out.println(account2);
        account.setBalance(105050);
        account2.setBalance(93990);

        System.out.println("=====================");

        List<Account> accounts = Arrays.asList(account, account2);
        for (Account ac : accounts) {
            System.out.println(ac);
        }

        System.out.println("=====================");

//        accounts.forEach(System.out::println); //리스트 순환
//        accounts.forEach( ac -> System.out.println(ac));

        System.out.println("=====================");

        accounts.forEach(ac -> {
            if (ac.getBalance() > 100000) {
                System.out.println(ac);
            }
        });
    }
}
