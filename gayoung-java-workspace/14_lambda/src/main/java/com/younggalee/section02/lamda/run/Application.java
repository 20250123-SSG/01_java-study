package com.younggalee.section02.lamda.run;

import com.younggalee.section02.lamda.my_functional_interface.FuncInterface1;
import com.younggalee.section02.lamda.my_functional_interface.FuncInterface2;
import com.younggalee.section02.lamda.my_functional_interface.FuncInterface3;
import com.younggalee.section02.lamda.my_functional_interface.FuncInterface4;

public class Application {
    public static void main(String[] args) {
        /*
        람다 표현식
        1. Lambda Expression
        2. jdk 8에 추가된 기능으로 메소드를 하나의 식으로 표현할 수 있음.
           이때, 매소드를 람다식으로 표현하면 메소드 이름이 없는 익명함수라고도 함.
        3. 함수형 인터페이스를 통해 구현시 사용가능
        4. 장점
           1) 단순함
           2) 컬렉션, 스트림을 연계해서 데이터를 쉽게 조작할 수 있음
              >> 불필요하게 반복되는 코드를 제거할 수 있음
        5. 표현식
            (매개변수) -> {실행 및 반환 구문}

         */
        //case1. 매개변수x, 반환값x 경우

        FuncInterface1 func1 = () -> {
            System.out.println("안녕");
        }; // print 오버라이딩 함.

        func1.print();

        FuncInterface1 func1_2 = () -> System.out.println("hello");
        func1_2.print();

        // 실행구문이 여러개라면 {} 반드시 표기, 한개라면 {} 생략 가능

        // case2. 매개변수x, 반환 값O 경우
        FuncInterface2 func2 = () -> {
            int sum = 0;
            for (int i=1; i<=10; i++){
                sum += i;
            }
            return sum;
        };
        System.out.println(func2.total());

        FuncInterface2 func2_2 = () -> {
            int sum = 0;
            for (int i=1; i<=100; i++){
                sum += i;
            }
            return sum;
        };
        System.out.println(func2_2.total());


        // case3. 매개변수O, 반환값X 경우
        FuncInterface3 func3 = (msg) -> System.out.println("메세지" + msg);
        FuncInterface3 func3_2 = /*매개변수가 한개일 경우 괄호 생략 가능*/ msg -> System.out.println(msg.length());
        FuncInterface3 func3_3 = System.out::println; // 메소드 참조 (참조연산) **************
        //매개변수로 전달된 값을 그대로 출력해주고 싶을 때 ::

        func3.print(" 람다연습 ");
        func3_2.print(" 람다연습 ");
        func3_3.print(" 람다연습 ");

        // case4. 매개변수O, 반환값O 경우
        FuncInterface4 func4_1 = (num1, num2) -> num1 - num2; // 단순 뺄셈
        System.out.println(func4_1.minus(3, 5));

        // 매개변수명은 다르게 작성가능, 타입도 작성가능
        // 실행구문이 특정값을 반환하는 구문만 존재할 경우 {}, return 생략 가능

    }
}

