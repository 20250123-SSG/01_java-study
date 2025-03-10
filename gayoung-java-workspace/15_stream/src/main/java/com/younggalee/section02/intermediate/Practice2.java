package com.younggalee.section02.intermediate;

import java.io.File;
import java.util.Arrays;

public class Practice2 {
    public static void main(String[] args) {
        // 실습. JAVA_HOME내의 각 항목의 이름뒤에 "폴더", "파일" 추가해서 출력하기
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");
        Arrays.stream(javaHome.listFiles()).map(file -> file.getName() + (file.isDirectory() ? "폴더" : "파일")).forEach(System.out::println);
    }
}
