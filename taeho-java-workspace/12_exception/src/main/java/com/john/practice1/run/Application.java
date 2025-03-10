package com.john.practice1.run;

import com.john.practice1.controller.NamingTest;
import com.john.practice1.exception.NamingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        NamingTest test = new NamingTest();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("문자열을 입력하세요: ");
        try {
            String str = br.readLine();
            test.isNumFirst(str);
            test.isReservedWord(str);
            test.isSpecialWord(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
