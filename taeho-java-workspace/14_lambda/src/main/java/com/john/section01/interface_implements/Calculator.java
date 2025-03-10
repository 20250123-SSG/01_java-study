package com.john.section01.interface_implements;

/*
    ## 인터페이스에 정의된 추상메서드를 활용하는 방법 3가지
    1. 인터페이스를 상속받는 클래스를 정의해서 기능을 완성한 후 사용
    2. 익명클래스를 활용하여 메서드 기능을 완성한 후 사용
    3. 람다식을 활용하는 방법
 */
public interface Calculator {

    int calc(int num1, int num2);

}
