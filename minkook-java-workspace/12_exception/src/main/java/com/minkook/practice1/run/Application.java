package com.minkook.practice1.run;

import com.minkook.practice1.controller.NamingTest;
import com.minkook.practice1.exception.NamingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void  main(String [] args) throws IOException {
        NamingTest nt = new NamingTest();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("변수명: ");
            String user = br.readLine();
            nt.isReservedWord(user);
            nt.isSpecialWord(user);
            nt.isNumFirst(user);
        }catch (NamingException e){
            System.out.println("모든 결과값이 true일 경우 사용가능하다");
            System.out.println("예외발생!!");
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }

    }
}
