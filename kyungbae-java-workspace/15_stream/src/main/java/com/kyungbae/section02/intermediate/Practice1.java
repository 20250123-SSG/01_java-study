package com.kyungbae.section02.intermediate;

import java.io.File;
import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {

        // JAVA_HOME 내에서의 디렉토리만 이름 출력하기
        File javaHome = new File("C:\\dev\\env\\jdk-17.0.14_7");

        Arrays.stream(javaHome.listFiles()).filter(File::isDirectory)
                .forEach(a -> System.out.println(a.getName()));

    }
}
