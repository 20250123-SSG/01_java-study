package com.ino.section02.intermediate;

import java.io.File;
import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
        Arrays.stream(javaHome.listFiles()).filter(File::isDirectory).forEach(file -> System.out.println(file.getName()));
    }
}
