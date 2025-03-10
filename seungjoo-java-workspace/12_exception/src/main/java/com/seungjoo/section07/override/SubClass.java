package com.seungjoo.section07.override;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

public class SubClass extends SuperClass {

//예외처리 없이 오버라이딩 가능
//    @Override
//    public void method(){}
//    @Override
//    public void method() throws IOException{}
    // 부모 메소드 측의 예외 타입보다 더 상위타입으로는 오버라이딩 불가능
//    @Override
//    public void method() throws Exception{}

    @Override // 부모 메소드 측의 예외 타입보다 더 하위타입으로는 오버라이딩 가능
    public void method() throws  FileNotFoundException {}
}
