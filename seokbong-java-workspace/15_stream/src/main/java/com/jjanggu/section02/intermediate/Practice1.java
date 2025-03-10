package com.jjanggu.section02.intermediate;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {

        // 실습. JAVA_HOME 내에서의 디렉토리만 이름 출력하기

        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        Arrays.stream(javaHome.listFiles())
                .filter(file -> file.isDirectory())
                .forEach( dir -> System.out.println(dir.getName()));

    }
}
