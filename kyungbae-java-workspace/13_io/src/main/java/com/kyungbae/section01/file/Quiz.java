package com.kyungbae.section01.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Quiz {
    public static void main(String[] args) {

        // 실습
        // 코드 실행시점의 날짜로 디렉토리가 만들어지도록 하시오.
        // ex) C:\2025\02\27

//        LocalDate ld = LocalDate.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy\\MM\\dd");
//        String fileName = ("C:\\" + dtf.format(ld));
        String fileName = ("C:\\" + DateTimeFormatter.ofPattern("yyyy\\MM\\dd").format(LocalDate.now()));
        File f = new File(fileName);

        if (!f.exists()) {
            f.mkdirs();
            System.out.println(fileName + " 생성완료");
        } else {
            System.out.println(fileName + " 은 이미 있는 파일입니다.");
        }


    }
}
