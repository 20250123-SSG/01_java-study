package com.minkook.section01.interface_implements;

public class Application2 {
    public static void main(String [] args){
        Calculator sumCalc = new SumCalculator();
        System.out.println("덧셈결과:" + sumCalc.calc(5,7));

        Calculator divcal = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1-num2;
            }
        };
        System.out.println("뺄셈결과:" + divcal.calc(5,7));

    }
}
