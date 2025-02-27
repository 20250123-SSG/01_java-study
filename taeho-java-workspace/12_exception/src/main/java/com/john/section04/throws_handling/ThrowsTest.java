package com.john.section04.throws_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowsTest {

    // try ~ catch를 이용해 에러 발생 부분 예외 처리
    public void exectionCase(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
        } catch (IOException e){
            //
        }
    }

    // throws: 발생되는 예외를 위임하여 예외를 회피
    // 해당 메서드를 호출하는 곳에 예외를 작성
    public void exceptionCase2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("문자열 입력: ");
    }
}
