package com.seungjoo.section01.file;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Quiz {
    public static void main(String[] args) {
//        File dir = new File("/Users/eun07213/2025/02/27");


//        Date today = new Date();
//        Calendar today = Calendar.getInstance();
        LocalDate today = LocalDate.now();
        String formatStr = DateTimeFormatter.ofPattern("yyyy//MM//dd").format(today);
//        String dirPath = "/Users/" + formatStr;

        String dirPath = "/Users/" + DateTimeFormatter.ofPattern("yyyy//MM//dd").format(LocalDate.now());
        File dir = new File(dirPath);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        System.out.println("디렉토리가 생성되었습니다.");
    }
}
