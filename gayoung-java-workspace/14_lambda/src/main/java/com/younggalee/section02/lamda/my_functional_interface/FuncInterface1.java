package com.younggalee.section02.lamda.my_functional_interface;

/* 함수형 인터페이스
    1. 추상메소드가 단 1개 존재하는 인터페이스
    2. 인터페이스 상단에 @FunctionalInterface를 작성해둘 수 있음
       : 추상메소드가 1개만 존재하고 있는지 검증해줌 (컴파일)
     */

// case1. 매개변수x, 반환값x
@FunctionalInterface
public interface FuncInterface1 {
    void print(); // 무언가를 출력하는 용도의 메소드
}
