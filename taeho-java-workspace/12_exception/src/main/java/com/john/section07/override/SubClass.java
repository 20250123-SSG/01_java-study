package com.john.section07.override;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class SubClass extends SuperClass {

    // 부모의 메서드를 overriding 할 때, 예외처리까지 따라갈 필요는 없음
//    @Override
//    public void method(){}

    // 부모 메서드 측의 같은 예외를 던져주는 구문으로도 작성가능
//    @Override
//    public void method() throws IOException{}

    // 부모 메서드의 예외처리 타입보다 상위로 오버라이딩 불가
//    @Override
//    public void method() throws Exception{}
    
    // 부모 메서드의 예외처리 타입보다 하위로는 오버라이딩 가능
//    @Override
//    public void method() throws FileAlreadyExistsException {}
}
