package com.seungjoo.section02.lambda.run;

import com.seungjoo.section02.lambda.functional_lambda.my_functional_interface.FuncInterface1;
import com.seungjoo.section02.lambda.functional_lambda.my_functional_interface.FuncInterface3;
import com.seungjoo.section02.lambda.functional_lambda.my_functional_interface.FunctionalInterface2;

public class Application {
    public static void main(String[] args) {
        FuncInterface1 func1_1 = () -> {
            System.out.println("안녕");
            System.out.println("잘가"); //매개변수가 없는 메소드인경우()에 변수 넣으면 안됨,
            //void이므로 반환값도 없음
        }; //print 오버라이딩


        FuncInterface1 func1_2 = () -> System.out.println("hello");
        func1_2.print();  //실행 구문이 한개라면 {} 생략 가능


        System.out.println("=====================");

        FunctionalInterface2 func2_1 = () -> {
            int sum = 0;
            for (int i = 0; i <= 10; i++) {
                sum += i;

            }
            ;
            return sum;
        };
        System.out.println(func2_1.total());

    }

    FuncInterface3 func3_1 = (msg) -> System.out.println("메세지: " + msg);

}




