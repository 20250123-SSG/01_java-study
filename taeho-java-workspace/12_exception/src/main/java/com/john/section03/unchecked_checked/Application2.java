package com.john.section03.unchecked_checked;


/*
    Checked Exception
    - 예외 핸들링이 없으면 프로그램이 작동하지 않는 예외 클래스들
    => 예외 처리를 하지 않으면 애초에 컴파일 에러가 발생되어 프로그램 실행 자체가 불가능

    - 예외처리, 예외회피 둘 중에 하나로 핸들링을 해야됨
    - RuntimeException 클래스를 제외한 모든 예외 클래스
 */

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Application2 {
    public static void main(String[] args) {
        try {
            new URL("https://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            new File("test.txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
