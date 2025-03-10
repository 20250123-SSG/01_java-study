package com.sotogito.section02.intermediate;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Practice2 {
    public static void main(String[] args) {
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        Arrays.stream(Objects.requireNonNull(javaHome.listFiles()))
                .map(file -> ((file.isDirectory()) ? "폴더" : "파일") + file.getName())
                .forEach(System.out::println);

    }
}
