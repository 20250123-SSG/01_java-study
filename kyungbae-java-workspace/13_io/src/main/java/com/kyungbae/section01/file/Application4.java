package com.kyungbae.section01.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class Application4 {
    public static void main(String[] args) {

        // 4. 디렉토리 및 파일 정보 확인

        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        // listFiles() : 하위 디렉토리 및 파일들을 File 인스턴스로 담은 File[] 반환
        File[] files = javaHome.listFiles();

        if (files != null) {
            System.out.println("디렉토리 및 파일 개수: " + files.length);
        } else {
            System.out.println("디렉토리 및 파일이 없습니다.");
        }

        for(File file : files){
            // getPath() : 파일 및 디렉토리의 경로 반환
            System.out.println(file.getPath());

            // getName() : 파일 또는 디렉토리의 이름 반환
            System.out.print(file.getName());

            // isFile() : 파일이면 true 반환, 디렉토리면 false
            System.out.println(file.isFile() ? ".file" : "");

            // lastModified() : 최종수정일을 반환 (long): millisecond
            long lastModified = file.lastModified();
            System.out.println("수정일: " + new SimpleDateFormat("yyyy.MM.dd").format(lastModified));

            // isDirectory() : 디렉토리면 true 반환
            // length() : 파일의 크기를 byte 단위로 반환 (1KB = 1024B)
            int size = file.isDirectory() ? 0 : (int)Math.ceil(file.length()/1024.0);
            if(size == 0){
            }else {
                System.out.println("크기: " + size + "KB");
            }

            System.out.println("----------------------------------");
        }
    }
}
