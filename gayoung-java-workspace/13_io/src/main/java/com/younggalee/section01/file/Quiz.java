package com.younggalee.section01.file;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.text.DateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Quiz {
    public static void main(String[] args) {
        //실습. 코드 실행시점의 날짜로 디렉토리가 만들어지도록 하시오. ex) c:\2025\02\27

        LocalDate date = LocalDate.now();
//        String formatStr = DateTimeFormatter.ofPattern("yyyy\\MM\\dd").format(date);
//        String dirpath = "c:\\" + formatStr;

        String dirpath = "c:\\storage\\" + DateTimeFormatter.ofPattern("yyyy\\MM\\dd").format(LocalDate.now());
        File dir = new File(dirpath);
        if( !dir.exists() ) {
             dir.mkdirs();
        }
        System.out.println("디렉토리가 생성되었습니다.");

//        String date2 = date.toString().replace("-","\\");
//        System.out.println(date2);
//        File f = new File("c:\\storage\\" + date2);
//        f.mkdirs();


    }
}
