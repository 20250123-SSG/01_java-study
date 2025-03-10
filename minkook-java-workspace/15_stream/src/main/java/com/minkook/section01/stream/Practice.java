package com.minkook.section01.stream;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Practice {
    public static void main(String [] args){
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        Stream<File> fileStream = Arrays.stream(javaHome.listFiles());
        fileStream.forEach(file -> System.out.println(file.getName()));
    }
}
