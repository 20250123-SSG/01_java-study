package com.jjanggu.section01.interface_implements;

public class Application1 {
    public static void main(String[] args) {
        /*
            ## 인터페이스 구현 방식1 ##
            구현 목적에 맞게 해당 인터페이스를 구현한(implements) 각 클래스를 새로이 만들어 활용

            public interface A {
                // 추상메소드
            }

            public class B implements A {
                // B 목적에 맞는 방식으로 오버라이딩 => 메소드 기능 완성
            }
            A a = new B();
            a.메소드();
         */

        Calculator sumCalc = new SumCalculator();
        System.out.println( "덧셈결과 : " + sumCalc.calc(5,7) );

        Calculator subCalc = new SubCalculator();
        System.out.println( "뺄셈결과 : " + subCalc.calc(5,7) );

        /*
            단점. 목적에 맞는 구현 클래스를 매번 만들어야되는게 번거로움
            장점. 한번 구현된 클래스가 있기대문에 필요하면 바로 생성해서 사용 가능
         */

    }
}
