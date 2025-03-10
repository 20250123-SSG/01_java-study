package com.ino.section02.intermediate;

import java.io.File;
import java.util.Arrays;

public class Practice2 {
    public static void main(String[] args) {
        File[] eleOfJavaHome = new File("C:\\dev\\env\\jdk-17.0.14_7").listFiles();
        Arrays.stream(eleOfJavaHome).map( ele -> ele.getName() + (ele.isDirectory() ? "folder" : "file")).forEach(System.out::println);

    }
}
