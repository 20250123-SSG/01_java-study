package com.jjanggu.section04.throws_handling;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException { // 마지막까지 throws로 회피하면 JVM이 처리함

        ThrowsTest tt = new ThrowsTest();

        /*
        try {
            tt.exceptionCase();
        }catch(IOException e){
            // 처리구문
        }
         */

        tt.exceptionCase();

    }
}
