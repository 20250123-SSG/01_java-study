package com.ino.section01.stream;

import java.io.*;
import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
        File[] listHomeFiles = javaHome.listFiles();
        Arrays.stream(listHomeFiles).forEach( f -> System.out.println(f.getName()));
    }
}
