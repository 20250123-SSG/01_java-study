package com.minkook.section04.throws_handling;

import java.io.IOException;

public class Application {
    public static void main(String [] args) throws IOException { //마지막까지 throws 회피하면 JVM이 처리함
        ThrowsTest tt = new ThrowsTest();
        tt.exceptionCase();
    }
}
