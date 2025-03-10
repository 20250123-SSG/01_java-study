package com.jjanggu.section01.interface_implements;

public class Application2 {
    public static void main(String[] args) {
        /*
            ## 인터페이스 구현 방식2 ##
            별도의 구현 클래스를 만들지 않고
            인터페이스 생성시 바로 구현하는 방식

            public interface A {
                // 추상메소드
            }
            A a = new A(){
                // 사용목적에 맞춰 오버라이딩 => 메소드 기능 완성
            };
         */

        Calculator supCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 * num2;
            }
        };
        System.out.println("뺄셈 결과 : " +  supCalc.calc(5,7) );

        Calculator divCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 / num2;
            }
        };
        System.out.println("나눗셈결과 : " + divCalc.calc(7,5) );

        /*
            장점. 구현 클래스를 변도로 만들어둘 필요없이 필요할때 바로 구현해서 쓰면됨
                 어떤 기능으로 동작될지가 가시적으로 보여짐
            단점. 해당 목적의 기능을 다시 써야될 경우 매번 익명클래스 방식으로 새로이 정의해야됨 (재사용 불가)
                 코드의 가독성이 떨어짐
         */
    }
}
