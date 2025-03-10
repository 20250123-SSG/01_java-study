package com.minkook.section07.override;

import java.io.FileNotFoundException;

public class SubClass extends SuperClass {

    //예외 없이 오버라이딩 가능
//    @Override
//    public void method(){
//
//    }
//    @Override
//    public void method() throws IOException{
//
//    }
    
    //부모 메소드 측의 예외 타입보다 더 상위 타입으로는 오버라이딩 불가능
//    @Override
//    public void method() throws Exception{
//
//    }
    
    //부모 메소드 측의 예외타입보다 더 하위 타입(구체적인 예외상황)으로는 오버라이딩 가능
    @Override
    public void method() throws FileNotFoundException {

    }
}
