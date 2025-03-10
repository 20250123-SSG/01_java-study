package com.seungjoo.section01.inteface_implements;

public class SumCalculator implements Calculator {



    @Override
    public int calc(int num1, int num2){
        return num1 + num2;
    }
}
