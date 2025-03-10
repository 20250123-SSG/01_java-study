package com.younggalee.section04.references;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Application {
    /*
    ## 메소드 참조
    1. 함수형 인터페이스를 람다식이 아닌 일반 메소드를 참조시켜 선언하는 방법
    2. 이미 존재하는 메소드를 참조하여 람다식에서 불필요한 매개변수 선언을 제거할 수 있음
    3. 함수형 인터페이스의 매개변수, 반환타입과 참조할 메소드의 매개변수, 반환타입이 같아야됨.
    4. 표현식
    1) 정적 메소드 참조 >> 클래스명::staticMethodName
    2) 인스턴스 메소드 참조 >> 참조변수::instanceMethodName
    3) 특정 타입의 객체의 메소드를 참조 >> 타입::methodName
    4) 생성자 참조 >> 클래스명::new
     */

    // case1. 특정 정수값을 전달받아 절대값을 반환해주는 Function
//    Function<Integer, Integer> function = num -> Math.abs(num); // 전달값 가지고 static 메소드 실행 결과 반환

    public static void main(String[] args) {
        Function<Integer, Integer> function = Math::abs;
        System.out.println(function.apply(-5));

        // case2. 특정값을 전달받아 단지 출력만해주는 Consumer
//        Consumer<Object> consumer = obj -> System.out.println(obj); // 전달값 가지고 Systme.out(PrintStream 인스턴스)의 println 메소드 실행
        Consumer<Object> consumer = System.out::println;
        consumer.accept("hello world");
        consumer.accept(123);

        // case3. 두개의 문자열을 전달받아 일치하는지 비교하여 boolean 반환해주는 BiFunction
//        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2); // 첫번째 전달값의 equals 메소드 실행
        BiFunction<String, String, Boolean> biFunction = String :: equals; // 알아서 값 전달됨...
        System.out.println(biFunction.apply("hello", "world"));

        // case4. 이름값을 전달받아 Account 객체 생성해서 반환해주는 Function
        Function<String, Account> function2 = name -> new Account(name); // 전달값 가지고 매개변수 생성자를 통해 객체 생성후 반환
        Function<String, Account> function3 = Account::new;
        Account acct1 = function3.apply("이가영");
        Account acct2 = function3.apply("이가영22");
        System.out.println(acct1);
        acct1.setBalance(150000);



        // 컬렉션을 활용해서 람다식 이용해보기
        List<Account> list = Arrays.asList(acct1,acct2);
        for (Account acc : list){
            System.out.println(acc);
        }

        //************************* 순회담당 메소드
        // forEach(Consumer<T> consumer) : 해당 메소드 호출시 순차적으로 요소를 가지고 어떤 내용을 수행시킬건지 람다식
        System.out.println("==========================");
        list.forEach(acc -> System.out.println(acc)); // 매개변수가 consumer객체임 (accept매소드 실행예상가능:입력있고, 출력없음)
        System.out.println("==========================");
        list.forEach(System.out::println);

        // 잔고가 2만원 이상인 계좌만 출력
        list.forEach(acc ->{
            if(acc.getBalance() >= 20000)
                System.out.println(acc);
        });

    }


}
