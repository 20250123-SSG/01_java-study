package com.john.section04.throws_handling;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {


        // 전달 받는 곳에서도 예외처리가 필수. 전달 받은 다음 한번 더 throws를 하면 JVM에서 처리

        ThrowsTest tt = new ThrowsTest();
        tt.exceptionCase2();
    }
}
