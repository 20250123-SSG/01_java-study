package com.seungjoo.section01.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class Application4 {

    public static void main(String[] args) {
        File javaHome = new File("/Library/Java/JavaVirtualMachines/jdk-17.0.1.jdk");

        File[] files = javaHome.listFiles(); //하위 디렉토리 및 파일들을 File인스턴스로 담은 File[] 반환

        System.out.println("디렉토리 및 파일의 개수" + files.length);

        for(File file : files){
            System.out.println(file);
            //getPath() : 파일 및 디렉토리의 경로 반환
            System.out.println("경로: " + file.getPath());
            //getName() : 파일 및 디렉토리명 반환
            System.out.println(file.getName());
            System.out.println("========");

            System.out.println(file.isFile()); //파일이면 true반환

            file.lastModified(); //최종 수정일을 반환(long)
            long lastModified = file.lastModified();
            System.out.println(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(lastModified));


            //isDirectory() : 디렉토리면 true반환
            // length() : 파일의 크기를 byte 단위로 반환(1kb = 1024B)
            int size = file.isDirectory() ? 0 :(int)Math.ceil(file.length() /1024.0);

            System.out.println("크기: " + size + "KB");
        }
    }

}
