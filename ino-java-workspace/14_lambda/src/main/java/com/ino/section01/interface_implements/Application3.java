package com.ino.section01.interface_implements;

public class Application3 {
    public static void main(String[] args) {
        Calculator mod = ((num1, num2) -> num1 % num2);
        System.out.println(mod.calc(20, 3));
    }
}