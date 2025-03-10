package com.sotogito.section02.lamdba.my_functional_interface;

/**
 * ## 함수형 인터페이스
 * 1. Functional Interfave
 * 2. 추상메서드가 1개 존재하는 인터페이스
 * 3. 인터페이스 상단에 @FunctionalInterface를 작성해야함 -> 추상메서드가 1개인지 검사함
 */
@FunctionalInterface
public interface FuncInterface1 {
    void print(); // 출력 용도
}
