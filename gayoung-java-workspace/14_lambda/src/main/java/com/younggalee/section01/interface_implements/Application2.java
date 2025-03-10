package com.younggalee.section01.interface_implements;

public class Application2 {
    public static void main(String[] args) {
        // interface 구현방식 2
        /*
        별도의 구현 클래스 만들지 않고 인터페이스 생성 시 바로 구현하는 방식

        A a = new A(){
        사용목적에 맞춰 오버라이딩 구현 >> 메소드 기능
        }
         */

        Calculator sup = new Calculator() /*이대로선언불가*/{

            @Override
            public int calc(int num1, int num2) {
                return num1 * num2;
            }
        }; // 세미콜론 꼭 있어야됨.

        System.out.println("곱셈결과 : " + sup.calc(5,7));

        Calculator div = new Calculator() /*이대로선언불가*/{
            @Override
            public int calc(int num1, int num2) {
                return num1 / num2;
            }
        }; // 세미콜론 꼭 있어야됨.

        System.out.println("나눗셈결과 : " + div.calc(5,7));

    }

    /*
    장점 : 구현 클래스를 별도로 만들어둘 필요 없이 필요할 때 바로 구현해서 쓰면 됨
           어떤 기능으로 동작될지가 가시적으로 보여짐
    단점 : 해당 목적의 기능을 다시 써야할 경우 매번 익명클래스 방식으로 새로이 정의해야됨 (재사용 불가)
           코드의 가독성이 떨어짐 (>> 가독성 향상 시킨 방식이 람다식)
     */

}

