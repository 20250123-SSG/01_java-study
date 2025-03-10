package com.kyungbae.practice1.run;

import com.kyungbae.practice1.controller.NamingTest;
import com.kyungbae.practice1.exception.NamingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException, NamingException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NamingTest nt = new NamingTest();

        int count = 0;
        try {
            System.out.print("변수명으로 쓸 문자열을 쓰시오 : ");
            String variable = br.readLine();
            nt.isNumfirst(variable);
            nt.isSpecialWord(variable);
            nt.isReservedWord(variable);
        } catch (Exception e){
            System.out.println(e.getMessage());
            count++;
        }
        if (count == 0) {
            System.out.println("사용 가능합니다.");
        }

    }
}
