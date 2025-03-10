package com.kyungbae.section04.throws_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowsTest {

    public void exceptionCase() throws IOException {

        // 사용자에게 문자열을 입력받아 출력하기

        // BufferedReader (JDK 1.1) / Scanner (JDK 1.5)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("문자열을 입력: ");

        String str = br.readLine();
        // IOException 예외핸들링 필수 => try catch문으로 해결하거나 thorws 이용

        System.out.println("사용자가 입력한 값: " + str);
    }

}
