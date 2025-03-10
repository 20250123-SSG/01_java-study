package com.minkook.section02.intermediate;

import java.io.File;
import java.util.Arrays;

public class Practice3 {
    public static void main(String [] args){
        //실습 .
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
        Arrays.stream(javaHome.listFiles())
                .map(file -> file.getName().toLowerCase())
                .sorted()
                .forEach(System.out::println);
    }
}
