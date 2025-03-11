package com.inyong.section01.interface_implements;

public interface Calculator {
    /*
    인터페이스에 정의된 추상메소드를 활용하는 방법 3가지
    1. 인터페이스를 상속받는 클래스를 저으이해서 기능을 완성한 후 사용
    2. 익명 클래스를 활용하여 메소드 기능을 완성한 후 사용
    3. 람다식을 활용하는 방법
     */

    public int cal(int num1, int num2);
}
