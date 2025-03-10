package com.minkook.section01.interface_implements;

public class Application3 {
    public static void main(String[]args){
        /*
            ## 인터페이스 구현 방식 ##
            익명클래스와 유사하나
            단, 구현시 오버라이딩해야되는 구문을 람다식을 통해 표현함
         */
        Calculator mod = (num1,num2) -> num1 % num2;
        System.out.println("나머지 결과 " + mod.calc(10,3));
    }
}
