package com.john.section02.lambda.my_functional_interface;

/*
    함수형 인터페이스(Functional Interface)
    - 추상 메서드가 한 개만 존재하는 인터페이스
    - 인터페이스 상단에 @FunctionalInterface를 작성해둘 수 있음
        => 추상메서드가 1개만 존재하는지 검증
 */

@FunctionalInterface
public interface FuncInterface1 {
    void print();
}
