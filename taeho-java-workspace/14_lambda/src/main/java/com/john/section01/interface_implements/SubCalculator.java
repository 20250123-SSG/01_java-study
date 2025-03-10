package com.john.section01.interface_implements;

public class SubCalculator implements Calculator {
    @Override
    public int calc(int num1, int num2) {
        return num1 - num2;
    }
}
