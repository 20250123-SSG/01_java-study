package com.minkook.section04.references;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Application {
    public static void main(String [] args){
        /*
            ## 메소드 참조 ##
            1. 함수형 인터페이스를 람다식이 아닌 일반 메소드를 참조시켜 선언하는 방법
            2. 이미 존재하는 메소드를 참조하여 람다식에서 불필요한 매개변수 선언을 제거 할 수 있음
            3. 함수형 인터페이스의 매개변수, 반환타입과 참조할 메소드의 매개변수, 반환타입이 같아야 됨
            4. 표현식
                1) 정적 메소드 참조 => 클래스명 :: staticMethodName
                2) 인스턴스 메소드 참조 => 참조 :: instanceMethodName
                3) 특정 타입의 객체 메소드 참조 =>
                4) 생성자 참조       => 클래스명 :: new
         */

        //case1. 특정 정수값을 전달받아 절대값을 반환해주는 Function
        Function<Integer,Integer> function = num -> Math.abs(num); //전달값 가지고 static 메소드 실행 결과 반환
        System.out.println(function.apply(-5));


        //case2: 특정값을 전달받아 단지 출력만 해주는 Consumer
        Consumer<Object>  consumer = System.out::println;
        consumer.accept("hello world");
        consumer.accept(123);

        //case3: 두 개의 문자열을 전달받아 일치하는지 비교하여 boolean 반환해주는 BiFunction
        BiFunction<String,String,Boolean> biFunction = String::equals;
        System.out.println(biFunction.apply("hello","world"));

        //case4:
        //Function<String,Account> function2 = name -> new Account(name); //전달값을 가지고 매개변수 생성자를통해 객체 생성후 반환
        Function<String,Account> function2 = Account::new;
        Account account1 = function2.apply("김영");
        Account account2 = function2.apply("김철수");
        System.out.println(account1);
        System.out.println(account2);

        account1.setBalance(15000);
        account2.setBalance(30000);

        System.out.println("====================================");

        //컬렉션을 활용해서 람다식 이용해보기
        List<Account> list = Arrays.asList(account1,account2);

        /*for(Account acc : list){
            System.out.println(acc);
        }*/

        // * foreach(Consumer<T> consumer ) : 해당 메소드 호출시 순차적으로 요소를 가지고 어떤 내용을 수행할껀지의 람다식
        list.forEach(acc -> System.out.println(acc));

        System.out.println("====================================");

        list.forEach(acc -> {
            if(acc.getBalance() >= 20000){
                System.out.println(acc);
            }
        });

    }
}
