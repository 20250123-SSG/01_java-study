package com.minkook.section02.lambda.run;

import com.minkook.section02.lambda.my_fuctional_interface.FuncInterface1;
import com.minkook.section02.lambda.my_fuctional_interface.FuncInterface2;
import com.minkook.section02.lambda.my_fuctional_interface.FuncInterface3;
import com.minkook.section02.lambda.my_fuctional_interface.FuncInterface4;

public class Application {
    public static void main(String [] args) {
        /*
            ## 람다 표현식 ##
            1. Lambda Expression
            2. JDK 8에 추가된 기능으로 메소드를 하나의 식으로 표현 할 수 있음
                이때 메소드를 람다식으로 표현하면 메소드 이름이 없는 익명함수라고도 함1
         */
        FuncInterface1 func_1 = () -> {
            System.out.println("안녕");
            System.out.println("잘가");
        };
        func_1.print();


        FuncInterface1 func_2 = () -> System.out.println("hello");
        func_2.print();

        //실행구문이 여러개라면 {} 반드시 표기, 한개라면 {} 생략가능
        System.out.println("========================================");
        FuncInterface2 func2_1 = () -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        };
        System.out.println(func2_1.total());
        System.out.println("========================================");

        //case3. 매개변수0,반환값x 경우
        // public inteface FuncInterface3 {void print(String msg)}

        FuncInterface3 func3_1 = (msg) -> System.out.println("메세지:" + msg);
        FuncInterface3 func3_2 = msg -> System.out.println("메세지:" + msg.length());
        FuncInterface3 func3_3 = System.out::println;

        func3_1.print("람다연습");
        func3_2.print("람다연습");
        func3_3.print("람다연습");

        System.out.println("========================================");
        FuncInterface4 func4_1 = (num1,num2) -> num1  - num2; //단순 뺄셈
        FuncInterface4 func4_2 = (num1,num2) -> Math.abs(num1 - num2);

        System.out.println(func4_1.minus(3,5));
        System.out.println(func4_2.minus(3,5));



    }
}
