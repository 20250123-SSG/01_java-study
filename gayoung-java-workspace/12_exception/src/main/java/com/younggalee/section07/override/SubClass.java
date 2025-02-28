package com.younggalee.section07.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass{
//    @Override
//    public void method() { }  // 예외 없이 오버라이딩 가능 (예외처리 필수는 아님)

//    @Override
//    public void method() throws IOException { } // 부모 메소드 측의 같은 예외(더 하위 예외)를 던저주는 구문으로 오버라이딩 가능

//    @Override
//    [x] public void method() throws Exception { }   // 이렇게 부모 측 예외보다 더 상위는 불가

    @Override
    public void method() throws FileNotFoundException {} // 이건 더 하위라 가능





}
