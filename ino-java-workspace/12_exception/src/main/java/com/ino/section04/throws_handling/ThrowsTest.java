package com.ino.section04.throws_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowsTest {

    public void exceptionCase() throws IOException {

        // 사용자에 문자열 입력받아 출력하기
        // BufferedReader (JDK 1.1) / Scanner (JDK 1.5)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("문자열 입력 :" );

//        try {
//            String str = br.readLine();
//        }
//        catch (IOException e) {
//
//        }

        String str = br.readLine();
    }
}
