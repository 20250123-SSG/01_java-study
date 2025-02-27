package com.pch.file;

import java.io.File;

public class Application4 {
    public static void main(String[] args) {
        File javahome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        File[] files = javahome.listFiles();
        System.out.println(files.length);

        for(File file : files) {
            System.out.println(file);
            System.out.println("==============");

        }
    }
}
