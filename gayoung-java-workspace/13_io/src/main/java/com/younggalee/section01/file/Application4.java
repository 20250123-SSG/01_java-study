package com.younggalee.section01.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

public class Application4 {
    public static void main(String[] args) {

        // 4. 디렉토리 및 파일 정보 확인

        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
        // listFiles() : 하위 디렉토리 및  파일들을 File 인스턴스로 담은 File[] 반환

        File[] files = javaHome.listFiles();

        for(File f : files){
            System.out.println(f.getPath());
            System.out.println(f.getName());
            System.out.println(f.isFile() ? "파일" : "폴더");

            // lastModified() : 최종수정일을 반환 (long)
            long lastModified = f.lastModified();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastModified));

            // isDirectory() / length() : 파일의 크기를 byte 단위로 반환 (1kb == 1024byte) > 나누기를 통해 단위변경할 경우 /1024.0으로 하기(나머지 사라짐)

            int size = f.isDirectory() ? 0 : (int) Math.ceil(f.length() / 1024.0);
            System.out.println(size + "kb");
        }
    }

}

