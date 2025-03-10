package com.ino.section01.interface_implements;

public class Application2 {
    public static void main(String[] args) {
        Calculator divCalc = new Calculator() {
            @Override
            public int calc(int num1, int num2) {
                return num1 / num2;
            }
        };
    }
}
