package com.kyungbae.section04.throws_handling;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException { // 마지막까지 throws를 사용하면 JVM이 처리
        ThrowsTest tt = new ThrowsTest();

        tt.exceptionCase();

    }
}
