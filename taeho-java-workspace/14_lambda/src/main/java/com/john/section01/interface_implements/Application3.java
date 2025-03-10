package com.john.section01.interface_implements;

public class Application3 {
    /*
        3. 람다식을 활용하는 방법
        구현시 오버라이딩 해야 하는 구문을 람다식을 통해 표현
        {Class} {val} = (type argName} -> {run code}
        람다식을 적용하려면 해당 인터페이스에서는 오로지 한개의 추상메서드만 존재
        => 함수형 인터페이스(Functional Interface)라고도 부름
     */
    public static void main(String[] args) {
        Calculator mod = (num1, num2) -> num1 % num2;
        System.out.println(mod.calc(3, 4));
    }
}
