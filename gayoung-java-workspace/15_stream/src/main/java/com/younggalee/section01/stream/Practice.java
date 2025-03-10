package com.younggalee.section01.stream;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {

        // 실습 JAVA_HOME 내의 모든 디렉토리 및 파일 이름을 출력하기
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
        File[] files = javaHome.listFiles();

        Stream<File> fileStream = Arrays.stream(files);
        fileStream.forEach(file -> System.out.println(file.getName()));
//        Arrays.stream(javaHome.listFiles()).forEach(file -> System.out.println(file.getName()));
    }
}
