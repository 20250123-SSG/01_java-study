package com.jjanggu.practice1.run;


import com.jjanggu.practice1.controller.NamingTest;
import com.jjanggu.practice1.exception.NamingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application{
    public static void main (String args[]) throws IOException,NamingException {

        NamingTest nt = new NamingTest();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        try {
            System.out.println("변수명으로 쓸 문자열을 쓰시오 : ");
            String user = br.readLine();

            nt.isReservedWord(user);
            nt.isSpecialWord(user);
            nt.isNumFirst(user);
            if(nt.isNumFirst(user) && nt.isSpecialWord(user) && nt.isNumFirst(user)) {
                System.out.println("사용가능");
            }
        }catch (NamingException e){
            System.out.println("예외 발생!");
            System.out.println(e.getMessage());
        }





        // BufferedReader를 이용하여 문자열을 입력 받고
        // 입력된 문자열에 변수명으로 사용 가능한지 여부 출력
        // “변수명으로 쓸 문자열을 쓰시오 : “  출력

        // NamingTest의 모든 메소드를 호출하여
        // 모든 결과값이 true일 경우 사용가능하다는 문구 출력

    }
}