package com.younggalee.section01.interface_implements;

import java.lang.annotation.Documented;

public class Application {
     /*
     ## 인터페이스 구현 방식1 ##  >> SumCalculator
     구현 목적에 맞게 해당 인터페이스를 구현한(implements) 각 클래스를 새로이 만들어
     (B 목적에 맞는 방식으로 오버라이딩 (메소드 기능 완성))
     (인터페이스 형식의 객체에 클래스 선언을 하여 활용했음. )
      */

    public static void main(String[] args) {
        // 생성은 불가능하지만 타입으로 선언은 가능
        Calculator sumCalc = new SumCalculator();
        System.out.println("덧셈 결과 : " + sumCalc.calc(5,7));

        Calculator subCalc = new SubCalculator();
        System.out.println("덧셈 결과 : " + subCalc.calc(5,7));

    }

    /*
    1번방식
    단점 : 목적에 맞는 구현 클래스를 매번 만들어야되는 게 번거로움
    장점 : 한번 구현된 클래스가 있기 때문에 필요시 바로 생성하여 사용가능함.
     */
}
