package com.podoseee.section02.lambda.run;

import com.podoseee.section02.lambda.my_functional_interface.FuncInterface1;
import com.podoseee.section02.lambda.my_functional_interface.FuncInterface2;
import com.podoseee.section02.lambda.my_functional_interface.FuncInterface3;
import com.podoseee.section02.lambda.my_functional_interface.FuncInterface4;

public class Application {
    public static void main(String[] args) {

        /*
            ## 람다 표현식 ##
            1. Lambda Expression
            2. JDK 8에 추가된 기능으로 메소드를 하나의 식으로 표현할 수 있음
               이때 메소드를 람다식으로 표현하면 메소드이름이 없는 익명함수라고도 함
            3. 함수형 인터페이스를 통해 구현시 사용 가능
            4. 장점
               1) 단순함
               2) 컬렉션, 스트림을 연계해서 데이터를 쉽게 조작할 수 있음
                  => 불필요하게 반복되는 코드를 제거할 수 있음
            5. 표현식
               (매개변수) -> { 실행 및 반환 구문 }
         */

        // case1. 매개변수x, 반환값x 경우
        // public interface FuncInterface1 { void print(); }
        FuncInterface1 func1_1 = () -> {
            System.out.println("안녕");
            System.out.println("잘가");
        }; // print 오버라이딩
        func1_1.print();

        FuncInterface1 func1_2 = () ->  System.out.println("hello");
        func1_2.print();
        // * 실행 구문이 여러개라면 {} 반드시 표기, 한개라면 {} 생략 가능

        System.out.println("=====================================");

        // case2. 매개변수x, 반환값o 경우
        // public interface FuncInterface2 { int total(); }
        FuncInterface2 func2_1 = () -> { // 1부터 10까지의 총합 구해서 반환
            int sum = 0;
            for(int i=1; i<=10; i++){
                sum += i;
            }
            return sum;
        };
        System.out.println(func2_1.total());

        FuncInterface2 func2_2 = () -> { // 1부터 100까지의 총합 구해서 반환
            int sum = 0;
            for(int i=1; i<=100; i++){
                sum += i;
            }
            return sum;
        };
        System.out.println(func2_2.total());

        System.out.println("=====================================");

        // case3. 매개변수o, 반환값x 경우
        // public interface FuncInterface3 { void print(String msg); }
        FuncInterface3 func3_1 = (msg) -> System.out.println("메세지: " + msg);
        FuncInterface3 func3_2 = msg -> System.out.println("메세지의 길이: " + msg.length());
        FuncInterface3 func3_3 = System.out::println; // 매개변수로 전달된 값을 곧바로 출력시키고자 할 때

        func3_1.print("람다연습");
        func3_2.print("람다연습");
        func3_3.print("람다연습");
        // * 매개변수가 한 개일 경우 () 생략 가능

        System.out.println("=====================================");

        // case4. 매개변수o, 반환값o 경우
        // public interface FuncInterface4 { int minus(int x, int y); }
        FuncInterface4 func4_1 = (num1, num2) -> num1 - num2; // 단순 뺄셈
        FuncInterface4 func4_2 = (int num1, int num2) -> Math.abs(num1 - num2); // 두 수의 차

        System.out.println(func4_1.minus(3, 5));
        System.out.println(func4_2.minus(3, 5));

        // * 매개변수명은 다르게 작성가능, 타입도 작성 가능
        // * 실행구문이 특정값을 반환하는 구문만 존재할 경우 {}, return 생략가능

    }
}
