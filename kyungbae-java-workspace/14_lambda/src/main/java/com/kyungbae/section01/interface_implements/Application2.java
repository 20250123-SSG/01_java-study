package com.kyungbae.section01.interface_implements;

public class Application2 {
    public static void main(String[] args) {

        // 2. 인터페이스 생성과 동시에 구현 (익명클래스)
        Calculator supCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 * num2;
            }
        };
        System.out.println("곱셈연산 " + supCalc.calc(2, 4));

        Calculator divCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 / num2;
            }
        };
        System.out.println("나눗셈연산 " + divCalc.calc(4, 2));

        /*
            장점. 구현 클래스를 별도로 만들필요 없이 바로 구현
                  어떤 기능으로 동작될지가 가시적으로 보여짐
            단점. 해당 목적의 기능을 다시 써야될 경우 매번 익명클래스 방식으로 새로 정의해야됨 (재사용불가)
                  코드의 가독성이 떨어짐
         */

    }
}
