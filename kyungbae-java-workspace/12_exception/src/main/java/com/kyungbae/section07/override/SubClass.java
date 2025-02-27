package com.kyungbae.section07.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass {

    // 예외 없이 오버라이딩
//    @Override
//    public void method(){}

    // 부모 메소드 측의 같은 예외를 던저주는 구문으로 오버라이딩 가능
//    @Override
//    public void method() throws IOException {}

    // 부모 메소드 측의 예외 타입보다 상위 타입으로 불가능
//    @Override
//    public void method() throws  Exception {}

    // 부모 메소드 측의 예외타입보다 더 하위 타입 으로 오버라이딩 가능
    @Override
    public void method() throws FileNotFoundException{}

}
