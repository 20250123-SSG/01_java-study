package com.younggalee.section02.intermediate;

import java.io.File;
import java.util.Arrays;

public class Practice3 {
    public static void main(String[] args) {

        // 실습. JAVA_HOME 내의 디렉토리 및 파일 이름을 내림차순 정렬해서 출력
        //       단, 이름을 다 소문자로 처리한 후 정렬하시오.
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
        Arrays.stream(javaHome.listFiles())
                .map(file -> file.getName().toLowerCase())
                .sorted( (name1, name2) -> name2.compareTo(name1) )
                .forEach(System.out::println);
    }
}