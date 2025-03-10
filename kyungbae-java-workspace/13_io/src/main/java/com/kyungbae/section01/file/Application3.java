package com.kyungbae.section01.file;

import java.io.File;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args){

        //3. 파일 생성

        // 1) 디렉토리가 존재하지 않을 경우 생성
        File dir = new File("C:\\storage");
        if(!dir.exists()){
            dir.mkdirs();
        }

        // 2) 파일생성
        File file = new File("C:\\storage\\Readme.txt");


        try {
            file.createNewFile(); // IOException 핸들링 필수
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
