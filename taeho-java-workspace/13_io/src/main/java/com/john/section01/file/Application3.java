package com.john.section01.file;

import java.io.File;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {
        File dir = new File("C:\\dev\\workspace\\01_java-study\\taeho-java-workspace\\13_io\\2025");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, "hello.txt");
        try {
            file.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
