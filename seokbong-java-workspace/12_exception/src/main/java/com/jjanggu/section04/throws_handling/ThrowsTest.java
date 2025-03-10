package com.jjanggu.section04.throws_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowsTest {

    /*
        ## throws ##
        발생되는 예외를 위임(떠넘기기, 던지기)하는 예외회피 방법
        즉, 해당 메소드를 호출하는 곳으로 예외를 던지는 방식

            public 반환타입 메소드명(매개변수) throws 예외클래스1, 예외클래스2, ...{
                // 예외 발생되는 구문
            }
     */



    public void exceptionCase() throws IOException{
        // 사용자에게 문자열을 입력받아 출력하기

        // * BufferedReader (JDK 1.1) / Scanner (JDK 1.5)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("문자열 입력 : ");

        /*
        try {
            String str = br.readLine(); // IOException 예외핸들링 필수 => try~catch문으로 여기서 해결하거나 throws로 떠넘기기
        }catch (IOException e){
            // 처리내용
        }
         */

        String str = br.readLine();

        System.out.println("사용자가 입력한 값 : " + str);
    }

}
