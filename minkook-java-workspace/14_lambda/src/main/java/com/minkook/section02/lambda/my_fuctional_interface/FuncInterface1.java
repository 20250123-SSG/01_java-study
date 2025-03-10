package com.minkook.section02.lambda.my_fuctional_interface;
/*
    ## 함수형 인터페이스 ##
    1. Functional Inteface
    2. 추상메소드가 단 1개 존재하는 인터페이스
    3. 인터페이스 상단에 @FuncionalInteface를 작성해 둘 수 있음
        -> 추상메소드 1개만 존재하는지 검증해줌
 */
@FunctionalInterface
public interface FuncInterface1 {
    void print(); //무언가를 출력하는 용도의 메소드
}
