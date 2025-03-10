package com.kyungbae.section01.file;

import java.io.File;

public class Application1 {
    public static void main(String[] args) {

        //1 . 디렉토리 만들기

        // 1) File 인스턴스 생성
        File dir = new File("C:\\storage");

        // exists() : 해당 디렉토리 및 파일의 존재 여부 반환
        System.out.println(dir.exists());

        // 2) 존재하지 않을 경우 생성
        if(!dir.exists()){
            // mkdir() :디렉토리 1개 생성 / mkdirs() : 디렉토리 여러경로 포함 생성 ( 1개도 됨)
            dir.mkdirs();
        }

        System.out.println(dir.exists());

    }
}
