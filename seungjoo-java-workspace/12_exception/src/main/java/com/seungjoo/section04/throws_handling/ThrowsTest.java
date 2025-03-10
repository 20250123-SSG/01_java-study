package com.seungjoo.section04.throws_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowsTest {

    public void exceptionCase() throws IOException {

//        //사용자에게 문자열을 입력받아 출력하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("문자열 입력:");
//        try{
//            String str = br.readLine(); //무조건 String으로 반환함, IOException 에외 핸들링 필수
//        }catch(IOException e){
//            System.out.println();
//        }
        String str = br.readLine();
        System.out.println("사용자가 입력한 값: " + str);


    }


}
