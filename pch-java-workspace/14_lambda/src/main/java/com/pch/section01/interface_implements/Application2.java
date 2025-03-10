package com.pch.section01.interface_implements;

public class Application2 {
    /*
        ## 인터페이스 구현 방식2 ##
        별도의 구현 클래스를 만들지 않고
        인터페이스를 곧바로 생성, 생성 시 추상 메서드의 구현체를 완성시켜야함.

        public interface A {
            // 추상메서드
        }

        A a = new A(){
            // 사용 목적에 맞춰 오버라이딩 => 메소드 기능 완성
        };
     */

    public static void main(String[] args) {

        Calculator supCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 * num2;
            }
        };
        System.out.println("곱셈결과: " + supCalc.calc(4, 5));


        Calculator divCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 / num2;
            }
        };
        System.out.println("나눗셈결과: "+divCalc.calc(4, 5));

        /*
            장점. 구현 클래스를 별도로 만들어둘 필요 없이 필요할 때 바로 구현해서 쓰면 됩니다.
                  어떤 기능으로 동작될지가 가시적으로 보여짐
            단점. 해당 목적의 기능을 다시 써야 할 경우 매번 익명클래스 방식으로 새롭게 정의해야 함(재사용 불가)
                  코드의 가독성이 떨어짐
         */

    }
}
