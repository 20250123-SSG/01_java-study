package com.kyungbae.section02.lanbda.run;

import com.kyungbae.section02.lanbda.my_functional_interface.FuncInterface1;
import com.kyungbae.section02.lanbda.my_functional_interface.FuncInterface2;
import com.kyungbae.section02.lanbda.my_functional_interface.FuncInterface3;
import com.kyungbae.section02.lanbda.my_functional_interface.FuncInterface4;

public class Application {
    public static void main(String[] args) {

        // 람다표현식

        // case1. 매개변수X, 반환값X 경우
        // public interface FuncInterface1 { void print(); }
        FuncInterface1 func1_1 = () -> {
            System.out.println("안녕");
            System.out.println("잘가");
        }; // print 오버라이딩
        func1_1.print();

        FuncInterface1 func1_2 = () -> System.out.println("hi");
        func1_2.print();

        System.out.println("--------------------------");

        // case2. 매개변수X, 반환값O 경우
        // public interface FuncInterface2 { int totla(); }
        FuncInterface2 func2_1 = () -> { // 1부터 10까지 총합 반환
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i+1;
            }
            return sum;
        };
        System.out.println(func2_1.total());
        FuncInterface2 func2_2 = () -> { // 1부터 100까지 총합 반환
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i+1;
            }
            return sum;
        };
        System.out.println(func2_2.total());

        System.out.println("--------------------------");

        // case3. 매개변수O, 반환값X 경우
        // public interface FuncInterface3 { void print(String msg);}
        FuncInterface3 func3_1 = (msg) -> System.out.println("메세지: " + msg);
        FuncInterface3 func3_2 = msg -> System.out.println("메세지의 길이: " + msg.length());
        // 매개변수가 1개일 경우 () 생략 가능
        FuncInterface3 func3_3 = System.out::println; // 매개변수로 전달된 값을 곧바로 출력시키고자 할때
        // 메소드 참조연산 "::"

        func3_1.print("람다연습");
        func3_2.print("람다연습");
        func3_3.print("람다연습");

        System.out.println("--------------------------");

        // case4. 매개변수O, 반환값O 경우
        // public interface FuncInterface4 { int minus(int x, int y); }
        FuncInterface4 func4_1 = (int num1,int num2) -> num1 - num2; // 단순 뺄셈
        // 매개변수명은 동일할 필요 없음, 타입 작성 가능함
        FuncInterface4 func4_2 = (a, b) -> Math.abs(a - b); // 두 수의 차
        // 실행구문이 특정값을 반환하는 구문만 존재할 경우 {}, return 생략 가능

        System.out.println(func4_1.minus(3,5));
        System.out.println(func4_2.minus(3,5));

    }
}
