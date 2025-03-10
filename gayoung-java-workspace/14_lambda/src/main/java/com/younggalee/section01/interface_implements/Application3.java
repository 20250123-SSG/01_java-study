package com.younggalee.section01.interface_implements;

public class Application3 {
    // 인터페이스 구현방식 3

    /*
    익명 클래스 와 유사하나
    단, 구현시 오버라이딩해야되는 구문을 람다식을 통해 표현함
     */

     //   Calculator mod = (매개변수) -> {실행구문}

    public static void main(String[] args) {

        Calculator mod = (num1, num2) -> num1 % num2;
        //한줄이면 생략도 가능함 {return num1 % num2};

        // *****************************
        // 단, 람다식을 적용하려면 해당 인터페이스에서는 오직 한개의 추상메소드만 존재해야함.
        // 이런걸 함수형(Functional) 인터페이스라고 함.

        System.out.println("나머지 결과 : " + mod.calc(10,3));
    }
}
