package com.ino.section01.file;

import java.io.File;

public class Application1 {
    public static void main(String[] args) {
        File dir = new File("C:\\storage");
        System.out.println(dir.exists());

        if (! dir.exists()) {
            dir.mkdirs();
        }
    }
}
