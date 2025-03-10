package com.sotogito.section02.lamdba.run;

import com.sotogito.section02.lamdba.my_functional_interface.FuncInterface1;
import com.sotogito.section02.lamdba.my_functional_interface.FuncInterface2;
import com.sotogito.section02.lamdba.my_functional_interface.FuncInterface3;
import com.sotogito.section02.lamdba.my_functional_interface.FuncInterface4;

public class Application {
    /**
     * 람다 표현식
     * 1. Lamdba Expression
     * 2. 함수형 인터페이스를 통해 구현시 사용
     * 3. 단순함
     * 4. 컬렉션 스트림을 연계해 데이터를 쉽게 조적 가능
     * (매게변수) -> {실행 및 반환 구문}
     *
     */

    public static void main(String[] args) {
        ///case1 매개변수x, 반환값x
        /**
         * 원래대로라면 impl클래스를 생성해야함,근데 람다로 바로 사용 가능
         * 단, 인터페이스에 정의된 행동이 1개여야함
         */
        FuncInterface1 func1_1 = () -> { 
            System.out.println("ewf");
            System.out.println("ewfe");
        };

        ///case1 매개변수x, 반환값o
        FuncInterface2 func2_1 = () -> {
            int sum = 0;
            for(int i = 1; i<= 10; i++) {
                sum = i*i;
            }
            return sum;
        };

        FuncInterface2 func2_2 = () -> {
            int sum = 0;
            for(int i = 1; i<= 100; i++) {
                sum = i*i;
            }
            return sum;
        };
        System.out.println(func2_1.total());
        System.out.println(func2_2.total());


        System.out.println("--------------------------------------------------");

        //case3. 매개변수o, 반환값x
        FuncInterface3 func3_1 = (msg) -> System.out.println("매세지 + "+msg);
        FuncInterface3 func3_2 = msg -> System.out.println("길이"+msg.length());
        //매개변수로 전달된 값을 곧바로 출력시키고자 할 때
        FuncInterface3 func3_3 = System.out::println;

        func3_1.print("aoroqustnsajrla");
        func3_2.print("ㄷㅈ랴ㅐㅓㅜㅁㄷ");
        func3_3.print("바로출력");

        System.out.println("aifeniofaiowjeiofjweiofoiwefiojewoijfoiwjeofijoiwejfoijwoefjiowefowjeofijwiefwef");

        //case4 매개변수o, 반환값o
        FuncInterface4 func4_1 = ((a, b) -> a-b);
        FuncInterface4 func4_1_1 = (a,b) -> {
            return a - b;
        };
        FuncInterface4 func4_2 = ((a, b) -> Math.abs(a-b));
        System.out.println(func4_1.minus(3,4));



    }
}
