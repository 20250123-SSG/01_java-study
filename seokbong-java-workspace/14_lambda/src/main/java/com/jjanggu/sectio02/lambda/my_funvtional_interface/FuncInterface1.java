package com.jjanggu.sectio02.lambda.my_funvtional_interface;

@FunctionalInterface
public interface FuncInterface1 {

    /*
        ## 함수형 인터페이스 ##
        1. Functional Interface
        2. 추상메소드가 단 1개 존재하는 인터페이스
        3. 인터페이스 상단에 @FunctionalInterface를 작성해둘 수 있음
           => 추상메소드 1개만 존재하는지 검증해줌
     */

        void print();



}
