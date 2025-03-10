package com.inyong.section03.unchecked_checked;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Application2 {
    public static void main(String[] args) {
        /*
        Checked Exception
        예외 핸들링이 없으면 프로그램이 동작되지 않는 예외 클래스들
        즉, 예외 처리를 하지 않으면 애초에 컴파일 에러가 발생되어 프로그램 실행 자체가 불가능

        예외처리, 예외회피 둘 중하나로 핸들링을 해야함
        RuntimeException 클래스를 제외한 모든 예외클래스
        - IOException
        - SqlException
        - FileNotFoundException
         */

        try{
            new URL("https://www.google.com");
        } catch (MalformedURLException e){
            System.out.println("예외 발생");
        }

        try {
            new File("test.txt").createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
