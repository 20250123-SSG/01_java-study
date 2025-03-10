package com.john.section02.intermediate;

import java.io.File;
import java.util.Arrays;

public class Practice2 {

    // JAVA_HOME 내의 각 항목 이름 뒤에 "폴더, "파일" 추가해서 출력하기
    public static void main(String[] args) {
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        Arrays.stream(javaHome.listFiles())
                .map(a -> a.getName() + (a.isDirectory() ? " 폴더" : " 파일"))
                .forEach(System.out::println);
    }
}
