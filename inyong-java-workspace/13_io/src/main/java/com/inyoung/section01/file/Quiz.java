package com.inyoung.section01.file;

import java.io.File;
import java.time.LocalDate;

public class Quiz {
    public static void main(String[] args) {
        //실습. 코드 실행시점의 날짜로 디렉토리가 만들어지도록 하시오. ex) c:\2025\02\27
        LocalDate date = LocalDate.now();
        String date2 = date.toString().replace('-','\\');
        System.out.println(date2);
        File f = new File("/Users/in-yong/storage/" + date2);
        f.mkdirs();
    }
}