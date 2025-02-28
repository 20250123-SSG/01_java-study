package com.younggalee.section01.file;

import java.io.File;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {


        // 1. 디렉토리 만들기
        // 1 ) File 인스턴스 생성
        File dir = new File("C:\\storage");

        // 존재하지 않을 경우 생성
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 2) 파일생성
        File file = new File("C:\\storage\\test.txt");
//        file.createNewFile(); // Ctrl + Alt + T 자동완성 (Surround with) ********************

        try{
            file.createNewFile(); // IOException 핸들링 필수
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
