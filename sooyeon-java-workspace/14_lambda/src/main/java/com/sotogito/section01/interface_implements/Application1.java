package com.sotogito.section01.interface_implements;

public class Application1 {
    public static void main(String[] args) {

        Calculator cal = new SumCalculator();
        System.out.println(cal.calc(1,2));


        Calculator calc2 = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 + num2;
            }
        };


        /**
         * 안터페이스를 impl해서 더하기 오버라이딩된 클래스릐 인스턴스를 생성해서 사용하는 것과 같은 결과를 냄
         */
        Calculator call = (num1, num2) -> num1 + num2;
        //Calculator cal = Integer::sum;
        System.out.println(call.calc(1,2));
        /**
         * 람다는 간편하게 오버라이딩된 기능처럼 사용할 수 있지만 인터페이스가 반드시 하나의 추상메서드만 정의되어있어한다.
         * => FunctionalInterface
         */
    }
}
