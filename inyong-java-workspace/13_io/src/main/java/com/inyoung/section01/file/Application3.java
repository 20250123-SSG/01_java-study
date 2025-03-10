package com.inyoung.section01.file;

import java.io.File;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {

        // 3. 파일 생성
        // 1) 디렉토리가 존재하지 않을 경우 생성
        File dir = new File("/Users/in-yong/storage");

        // exists() : 해당 디렉토리 및 파일의 존재 여부 반환
        System.out.println(dir.exists());

        // 2 ) 존재하지 않을 경우 생성
        if(!dir.exists() ){
            dir.mkdirs();
        }
        System.out.println(dir.exists());


        File file  = new File("/Users/in-yong/storage/test.txt");

        // 커멘드 알트 T
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        try {
            file.createNewFile(); //IOException 핸들링 필수
        }
        catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

//