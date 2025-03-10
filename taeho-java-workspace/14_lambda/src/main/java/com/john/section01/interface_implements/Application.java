package com.john.section01.interface_implements;

public class Application {
    public static void main(String[] args) {
        /*
            1. 인터페이스를 상속받는 클래스를 정의해서 기능을 완성한 후 사용
            단점: 목적에 맞는 구현 클래스를 매번 생성해야함
            장점: 구현된 클래스가 있어 필요하면 바로 생성해서 사용 가능
         */
        Calculator sumCalc = new SumCalculator();
        System.out.println(sumCalc.calc(4, 5));

        Calculator subCalc = new SubCalculator();
        System.out.println(subCalc.calc(4, 5));
    }

}
