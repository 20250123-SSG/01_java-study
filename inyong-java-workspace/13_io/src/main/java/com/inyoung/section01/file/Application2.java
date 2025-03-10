package com.inyoung.section01.file;

import java.io.File;

public class Application2 {
    public static void main(String[] args) {

        File dir = new File("/Users/in-yong/storage");

        // exists() : 해당 디렉토리 및 파일의 존재 여부 반환
        System.out.println(dir.exists());

        // 2 ) 존재하지 않을 경우 생성
        if(dir.exists() ){
            dir.delete();
        }
        System.out.println(dir.exists());
    }
}