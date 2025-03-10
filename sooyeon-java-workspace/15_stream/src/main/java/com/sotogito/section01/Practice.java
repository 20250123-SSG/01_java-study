package com.sotogito.section01;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {

        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

      //  Stream<File> files = Arrays.stream(Objects.requireNonNull(javaHome.listFiles()));

        Arrays.stream(Objects.requireNonNull(javaHome.listFiles()))
                .forEach(System.out::println);
        }
}
