package com.kyungbae.section01.interface_implements;

public class Application1 {
    public static void main(String[] args) {

        // 1. 인터페이스를 구현한 클래스를 만들어서 사용

        Calculator sumCalc = new SumCalculator();
        System.out.println("덧셈결과 " + sumCalc.calc(1,3));

        Calculator subCal = new SubCalculator();
        System.out.println("뺄셈결과 " + subCal.calc(1,3));

        /*
            단점. 목적에 맞는 구현클래스를 매번 만들어주어야 한다.
            장점. 한번 구현된 클래스가 있기 때문에 필요할때 바로 생성가능
         */

    }

}
