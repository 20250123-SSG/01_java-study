package com.seungjoo.section01.inteface_implements;

public class Application2 {
    public static void main(String[] args) {




        Calculator supCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1*num2;
            }
        };

        System.out.println("뺄셈 결과: " + supCalc.calc(5,7));
    }
    Calculator divCalc = new Calculator() {
        @Override
        public int calc(int num1, int num2) {
            return num1/num2;
        }
    };

}
