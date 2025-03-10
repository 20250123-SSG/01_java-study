package com.pch.section04.throws_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowsTest{
    /*
        ## throws ##
        발생되는 예외를 위임(떠넘기기, 던지기) 하는 예외 회피방법
        즉, 해당 메소드를 호출하는 곳으로 예외를 던지는 방식

            public 반환타입 메소드명(매개변수) throws 예외exception1, exception2, ... {
                // 예외 발생되는 구문

            }
     */

    public void exceptionCase() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("문자열 입력 : ");

        String s = br.readLine();

//        try {
//            s = br.readLine();
//        } catch (IOException e){
//
//        }

        System.out.println(s);
    }

    public void checkAge(int age){
        if(age < 0 || age > 120){
            throw new RuntimeException(age + "살은 존재할 수 없습니다.");
        }
        System.out.println(age + "살 이군요.");
    }

    public void checkGrade(int grade){
        
    }
}
