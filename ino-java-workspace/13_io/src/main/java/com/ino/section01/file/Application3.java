package com.ino.section01.file;

import java.io.File;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {
        File dir = new File("C:\\storage");
        if(!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File("C:\\storage\\test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
