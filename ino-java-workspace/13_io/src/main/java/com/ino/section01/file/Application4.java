package com.ino.section01.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class Application4 {
    public static void main(String[] args) {
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        File[] files = javaHome.listFiles();

        System.out.println(files.length);

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        for(File f : files) {
            System.out.println(f.getName());
            System.out.println(f.isFile() ? "파일" : "디렉토리");
            System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(f.lastModified()));
            int size = f.isDirectory() ? 0 : (int) Math.ceil(f.length() / 1024.0);
            System.out.println("size : " + size + "KB");
        }
    }
}
