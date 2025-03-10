package com.seungjoo.section01.inteface_implements;

public class Application1 {
    public static void main(String[] args) {

        Calculator sumCalc = new SumCalculator();
        System.out.println("덧셈 결과: " + sumCalc.calc(5, 4));
    }

}
