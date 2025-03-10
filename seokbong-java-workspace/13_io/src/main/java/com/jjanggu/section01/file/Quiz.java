package com.jjanggu.section01.file;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Quiz {

    public static void main(String[] args) {

        // 실습.
        // 코드 실행시점의 날짜로 디렉토리가 만들어지도록 하시오.
        // ex) C:\2025\02\27

//        Date today = new Date();                  => SimpleDateFormat
//        Calendar today = Calendar.getInstance();  => SimpleDateFormat

        /*
        LocalDate today = LocalDate.now();        //=> DateTimeFormatter
        String formatStr = DateTimeFormatter.ofPattern("yyyy\\MM\\dd\\").format(today);
        String dirPath = "C:\\" + formatStr;
         */

        String dirPath = "C:\\" + DateTimeFormatter.ofPattern("yyyy\\MM\\dd").format(LocalDate.now());

        File dir = new File(dirPath);
        if( !dir.exists()) {
            dir.mkdirs();
        }

        System.out.println("디렉토리가 생성되었습니다.");

    }
}
