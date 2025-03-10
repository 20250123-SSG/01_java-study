package com.seungjoo.section01.file;

import java.io.File;

public class Application {

    public static void main(String[] args) {
        //File 인스턴스 생성
        //백슬래시를 쓰고 싶을 때 \\
        File dir = new File("/Users/eun07213/storage");

        //exists() : 해당 디렉토리 및 파일의 존재 여부 반환
        System.out.println(dir.exists());

        //존재하지 않을 경우 생성
        if(!dir.exists()){
            //mkdi() / mkdirs(): 디렉토리로 생성
            dir.mkdirs();
        }
        System.out.println(dir.exists());
    }
}
