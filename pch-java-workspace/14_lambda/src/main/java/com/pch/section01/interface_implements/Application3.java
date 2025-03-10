package com.pch.section01.interface_implements;

public class Application3 {
    /*
        ## 인터페이스 구현 방식3 ##
        익명클래스와 유사하나
        단, 구현시 오버라이딩 해야하는 구문을 람다식을 통해 표현 가능
     */

    public static void main(String[] args) {
        Calculator mod = ((num1, num2) ->{ return num1 % num2;});
        System.out.println("나머지 결과 : "+mod.calc(3, 4));

        // 단, 람다식을 적용하려면 해당 인터페이스에서는 오로지 한 개의 추상메소드만 존재해야함
        // => 함수형 인터페이스(Functional Interface)라고 함
    }
}