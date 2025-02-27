package com.john.section01.file;

import java.io.File;

/*
    File
    - 디렉토리 및 파일을 관리하는 클래스
    - 특정 티렉토리 및 파일에 대한 CRUD 가능
 */
public class Application1 {
    public static void main(String[] args) {
        File dir = new File("C:\\dev\\workspace\\01_java-study\\taeho-java-workspace\\13_io\\ojoj\\real");
//        dir.mkdirs();

        // exists() : 디렉토리 혹은 파일 존재 여부

        if (!dir.exists()) {
            dir.mkdir();
        }
    }
}
