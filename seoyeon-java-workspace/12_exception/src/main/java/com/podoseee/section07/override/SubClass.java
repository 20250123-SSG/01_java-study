package com.podoseee.section07.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass {

    // '예외처리 없이' 오버라이딩 가능
    /*@Override
    public void method(){}*/

    // 부모 메소드 측의 '같은 예외'를 던져주는 구문으로 오버라이딩 가능
    /*@Override
    public void method() throws IOException{}*/

    // 부모 메소드 측의 예외 타입보다 '더 상위' 타입으로는 오버라이딩 '불가능'
    /*@Override
    public void method() throws Exception {}*/

    // 부모 메소드 측의 예외 타입보다 더 하위 타입(구체적인 예외상황)으로는 오버라이딩 가능
    /*@Override
    public void method() throws FileNotFoundException {}*/

}
