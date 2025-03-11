package com.ibe6.practice1.run;

import com.ibe6.practice1.controller.NamingTest;

import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("변수명으로 쓸 문자열을 쓰시오: ");
            NamingTest namingTest = new NamingTest();
            String str = br.readLine();
            namingTest.isReservedWord(str);
            namingTest.isSpecialWord(str);
            namingTest.isNumFirst(str);
            System.out.println("사용 가능합니다.");
        }catch (Exception e) {
            System.out.println("사용 불가능합니다. " + e.getMessage());
        }
        }

        // BufferedReader를 이용하여 문자열을 입력 받고
        // 입력된 문자열에 변수명으로 사용 가능한지 여부 출력
        // “변수명으로 쓸 문자열을 쓰시오 : “  출력

        // NamingTest의 모든 메소드를 호출하여
        // 모든 결과값이 true일 경우 사용가능하다는 문구 출력

    }
