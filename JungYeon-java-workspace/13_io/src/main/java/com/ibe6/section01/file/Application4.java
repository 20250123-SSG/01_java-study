package com.ibe6.section01.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class Application4 {
    public static void main(String[] args) {

        // 4. 디렉토리 및 파일 정보 확인

        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        // * listFiles() : 하위 디렉토리 및 파일들을 File 인스턴스로 담은 File[] 반환
        File[] files = javaHome.listFiles();

        System.out.println("디렉토리 및 파일의 개수: " + files.length);

        for(File file : files){

            // System.out.println(file);

            // * getPath() : 파일 및 디렉토리의 경로 반환
            System.out.println("경로: " + file.getPath());

            // * getName() : 파일 및 디렉토리명 반환
            System.out.println("이름: " + file.getName());

            // * isFile() : 파일이면 true 반환
            System.out.println("유형: " + (file.isFile() ? "파일" : "폴더"));

            // * lastModified() : 최정수정일을 반환 (long)
            long lastModified = file.lastModified();
            System.out.println("수정일: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastModified));

            // * isDirectory() : 디렉토리면 true반환
            // * length() : 파일의 크기를 byte 단위로 반환(1KB == 1024B) => KB단위로 변경 할 경우 / 1024
            int size = file.isDirectory() ? 0 : (int)Math.ceil(file.length() / 1024.0);
            System.out.println("크기: " + size + "KB");

            System.out.println("============================");
        }

    }
}
