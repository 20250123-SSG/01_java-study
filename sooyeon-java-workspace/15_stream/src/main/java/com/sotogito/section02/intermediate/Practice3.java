package com.sotogito.section02.intermediate;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Practice3 {
    public static void main(String[] args) {

        Arrays.stream(Objects.requireNonNull(new File("C:\\dev\\env\\jdk-17.0.14_7").listFiles()))

                .map(file -> file.getName().toLowerCase())

                .sorted((a, b) -> b.compareToIgnoreCase(a))

                .forEach(System.out::println);
    }
}
