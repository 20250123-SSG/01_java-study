package com.ino.section02.intermediate;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Practice3 {
    public static void main(String[] args) {
        Arrays.stream(new File("C:\\dev\\env\\jdk-17.0.14_7").listFiles())
                .sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
                .map( o1 -> o1.getName().toLowerCase())
                .forEach(System.out::println);
    }
}
