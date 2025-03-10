package com.seungjoo.practice1.run;

import com.seungjoo.practice1.controller.NamingTest;
import com.seungjoo.practice1.exception.NamingException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("변수명으로 쓸 문자열을 쓰시오 : ");

        NamingTest namingTest = new NamingTest();
        try {
            namingTest.isNumFirst("sye");
            namingTest.isReservedWord("sye");
            namingTest.isSpecialWord("sye");
            System.out.println("모든 결과값이 true일 경우 사용가능하다.");
        }catch (NamingException e){
            System.out.println(e.getMessage());
        }


    }



}
