package com.kyungbae.section04.references;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        // case1. 특정 정수값을 전달받아 절대값을 반환해주는 Function
//        Function<Integer, Integer> function = num -> Math.abs(num);
        Function<Integer, Integer> function = Math::abs; // 정적 메소드 참조 (static method reference)
        System.out.println(function.apply(-5));

        // case2. 특정값을 전달받아 단지 출력만해주는 Consumer
//        Consumer<Object> consumer = obj -> System.out.println(obj);
        Consumer<Object> consumer = System.out::println;
        consumer.accept("굿");

        // case3. 두개의 문자열을 전달받아 일치하는지 비교하여 boolean 반환해주는 BiFunction
        // BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2); // 첫번째 전달값(String타입의 인스턴스)의 equals메소드 실행
        BiFunction<String, String, Boolean> biFunction = String::equals;
        System.out.println(biFunction.apply("hello", "world"));

        // case4. 이름값을 전달받아 Account객체 생성해서 반환해주는 Function
//        Function<String, Account> function2 = name -> new Account(name);
        Function<String, Account> function2 = Account::new;

        Account account1 = function2.apply("김영희");
        Account account2 = function2.apply("홍길동");
        System.out.println(account1);
        System.out.println(account2);

        account1.setBalance(15000);
        account2.setBalance(35000);

        System.out.println("==============================");

        // 컬렉션을 활용해서 람다식 이용해보기
        List<Account> list = Arrays.asList(account1, account2);

//        for(Account acc : list){
//            System.out.println(acc);
//        }

        // forEach(Consumer<T> consumer) : 해당 메소드 호출 시 순차적으로 요소를 가지고 어떤내용을 수행시킬껀지의 람다식
//        list.forEach( acc -> System.out.println(acc) );
        list.forEach(System.out::println);

        System.out.println("------------------------------------");

        // 잔고가 2만원 이상인 계좌만 출력
        list.forEach(acc -> {
            if(acc.getBalance() >= 20000)
                System.out.println(acc);
        });

    }
}
