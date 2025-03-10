package com.seungjoo.section01.inteface_implements;

public class Application3 {

    public static void main(String[] args) {
        Calculator mod = (num1, num2) -> num1 %num2;
        System.out.println(mod.calc(10,3));
    }


}
