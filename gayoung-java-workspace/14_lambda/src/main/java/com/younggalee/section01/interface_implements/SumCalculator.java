package com.younggalee.section01.interface_implements;

public class SumCalculator implements Calculator {
     // 오버라이딩 생성조건 (시험문제)
    @Override
    public int calc(int num1, int num2){
        return num1 + num2;
    }
}
