package com.john.section02.intermediate;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Practice3 {
    public static void main(String[] args) {

        // JAVA_HOME 내의 디렉토리 및 파일 이름을 내림차순 정렬해서 출력
        // 이름을 다 소문자로 처리한 후 정렬
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        Arrays.stream(javaHome.listFiles())
                .map(a -> a.getName().toLowerCase())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }
}
