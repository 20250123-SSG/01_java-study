package com.john.section02.lambda.run;

import com.john.section02.lambda.my_functional_interface.FuncInterface1;
import com.john.section02.lambda.my_functional_interface.FuncInterface2;
import com.john.section02.lambda.my_functional_interface.FuncInterface3;

/*
    람다 표현식(Lambda Expression)
    - 메서드를 하나의 식으로 표현가능, 메서드를 람다식으로 표현하면 메서드이름이 없는 익명함수라고도 함
    - 함수형 인터페이스를 통해 구현 시 사용가가능

    장점
    - 단순함
    - 컬렉션, 스트림을 연계해서 데이터를 쉽게 조작할 수 있음
        => 불필요하게 반복되는 코드 제거
 */

public class Application {
    public static void main(String[] args) {
        FuncInterface1 func1_1 = () -> {
            System.out.println("func1_1");
        };
        func1_1.print();

        FuncInterface1 func1_2 = () -> System.out.println("func1_2");
        func1_2.print();

        System.out.println("========================================");

        FuncInterface2 func2_1 = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            return sum;
        };
        System.out.println(func2_1.total());

        FuncInterface2 func2_2 = () -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        };
        System.out.println(func2_2.total());

        System.out.println("========================================");

        FuncInterface3 func3_1 = (msg) -> {
            System.out.println(msg);
        };
        FuncInterface3 func3_2 = msg -> {
            System.out.println(msg.length());
        };
        // 메서드 참조
        FuncInterface3 func3_3 = System.out::println;

        func3_1.print("람다 테스트");
        func3_2.print("람다 테스트");
        func3_3.print("람다 테스트");

        System.out.println("========================================");

        FuncInterface4 func4_1 = (num1, num2) ->
            num1 - num2;

        FuncInterface4 func4_2 = (num1, num2) ->
            Math.abs(num1 - num2);

        System.out.println(func4_1.minus(2, 4));
        System.out.println(func4_2.minus(2, 4));
    }
}
