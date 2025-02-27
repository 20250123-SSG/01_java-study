package com.john.section01.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class Application4 {
    public static void main(String[] args) {
        File javaHome = new File("C:\\dev\\java\\jdk-17.0.14");

        // listFiles(): 하위 디렉토리 및 파일들을 File 인스턴스로 담은 File[] 반환
        File[] files = javaHome.listFiles();
        for (File file : files) {
//            System.out.println(file);
            System.out.println("경로: " + file.getPath());
            System.out.println("이름: "  + file.getName());
            System.out.println("유형: "  + (file.isFile() ? "파일" : "폴더"));
            // 최종수정일
            long lastModified = file.lastModified();
            System.out.println("수정일: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastModified));

            // isDirectory(): 폴더 확인
            // length(): 파일의 크기를 byte 단위로 반환
            int size = file.isDirectory() ? 0 : (int)Math.ceil(file.length() / 1024.0);
            System.out.println("파일의 크기: " + size + " KB");
            System.out.println("==============");
        }

        System.out.println("디렉토리 및 파일의 개수: " + files.length);
        
    }
}
