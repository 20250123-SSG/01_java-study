package com.kyungbae.section01.interface_implements;

public class Application3 {
    public static void main(String[] args) {

        // 3. 익명클래스 구현 시 람다식 사용

        Calculator mod = (num1, num2) -> num1 % num2;
        System.out.println("나머지연산 " + mod.calc(4,3));

        // 단, 람다식을 적용하려면 해당 인터페이스에서는 오로지 한개의 추상메소드만 존재해야됨
        // 함수형 인터페이스 (Functional Interface)
    }
}
