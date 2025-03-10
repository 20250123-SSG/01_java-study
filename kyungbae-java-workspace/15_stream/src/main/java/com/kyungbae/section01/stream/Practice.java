package com.kyungbae.section01.stream;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {

        // %JAVA_HOME% 경로 내의 모든 디렉토리 및 파일 이름 출력하기

        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
//        File[] files = javaHome.listFiles();
//        Stream<File> fileStream = Arrays.stream(files);

//        Stream<File> fileStream = Arrays.stream(javaHome.listFiles());
//        fileStream.forEach(a -> System.out.println(a.getName()));

        Arrays.stream(javaHome.listFiles())
                .forEach(a -> System.out.println(a.getName()));



    }
}
