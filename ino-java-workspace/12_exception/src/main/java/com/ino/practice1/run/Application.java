package com.ino.practice1.run;

import com.ino.practice1.controller.NamingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        NamingTest nt = new NamingTest();
        System.out.print("변수명으로 쓸 문자열을 쓰시오 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        nt.isNumFirst(str);
        nt.isReservedWord(str);
        nt.isSpecialWork(str);
    }
}
