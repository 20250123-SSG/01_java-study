package com.minkook.section01.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class Application4 {
    public static void main(String [] args) {
        //4. 디렉토리 및 파일 정보확인
        
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
        
        // *listFiles() 하위 디렉토리 및 파일들을 File 인스턴스로 담은 File[] 반환
        File[]files = javaHome.listFiles();

        System.out.println("디렉토리 및 파일의 개수: " + files.length);

        for(File file : files){
            // *getPath(): 파일 및 디렉토리의 경로 반환
            System.out.println("경로: " + file.getPath());
            // *getName() : 파일 및 디렉토리명 반환
            System.out.println("이름: " + file.getName());

            System.out.println("유형: " + (file.isFile() ? "파일":"폴더"));

            long lastModified = file.lastModified();
            System.out.println("수정일: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastModified));
            System.out.println("================");

            // * isDirectory() : 디렉토리면 true반환
            // * length() : 파일의 크기를 byte 단위로 반환(1KB == 1024B)
            int size = (int)(file.isDirectory() ? 0 : file.length() / 1024.0);
            System.out.println(size + "KBte");
        }
    }
}
