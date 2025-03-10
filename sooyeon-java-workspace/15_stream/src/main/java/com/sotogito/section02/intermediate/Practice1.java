package com.sotogito.section02.intermediate;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        Arrays.stream(Objects.requireNonNull(javaHome.listFiles()))
                .filter(File::isDirectory)
                .forEach(file -> System.out.println(file.getName()));

    }
}
