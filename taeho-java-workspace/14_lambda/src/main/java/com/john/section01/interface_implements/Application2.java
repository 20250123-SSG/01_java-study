package com.john.section01.interface_implements;


public class Application2 {
    /*
        2. 익명클래스를 활용하여 메서드 기능을 완성한 후 사용
        장점: 구현클래스를 별도로 만들어줄 필요없이 필요할 때 바로 구현해서 사용
             어떤 기능으로 동작될지가 가시적으로 보여짐
        단점: 해당목적의 기능을 다시 써야될 경우 매번 익명클래스 방식으로 새로이 정의 필요
             코드의 가독성
     */
    public static void main(String[] args) {
        Calculator supCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 * num2;
            }
        };
        System.out.println(supCalc.calc(4, 5));

        Calculator divCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 / num2;
            }
        };
        System.out.println(divCalc.calc(4, 5));
    }
}
