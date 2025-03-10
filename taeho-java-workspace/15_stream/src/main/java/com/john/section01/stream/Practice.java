package com.john.section01.stream;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        File javaHome = new File("C:\\dev\\java\\jdk-17.0.14");

        Stream<File> files = Arrays.stream(javaHome.listFiles());
        files.forEach(file -> System.out.println(file.getName()));

        Arrays.stream(javaHome.listFiles())
                .forEach(file -> System.out.println(file.getName()));
    }
}
