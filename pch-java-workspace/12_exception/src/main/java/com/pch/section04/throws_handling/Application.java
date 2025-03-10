package com.pch.section04.throws_handling;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ThrowsTest tt = new ThrowsTest();

        tt.exceptionCase();
    }
}
