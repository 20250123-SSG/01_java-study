package com.ino.section01.file;

import java.io.File;

public class Application2 {
    public static void main(String[] args) {
        File dir = new File("\"C:\\\\storage\"");
        if(dir.exists()) {
            dir.delete();
        }
    }
}
