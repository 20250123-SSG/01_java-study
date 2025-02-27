package com.john.section01.file;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class Quiz {

    public static void main(String[] args) {
        /*
            날짜 생성 방법
            Date today = new Date();                    => SimpleDateFormat
            Calendar today = Calendar.getInstance();    => SimpleDateFormat
            LocalDate today = LocalDate.now();          => DateTimeFormatter
         */
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//        StringTokenizer st = new StringTokenizer(localDate.toString(), "-");
//        String year = st.nextToken();
//        String month = st.nextToken();
//        String day = st.nextToken();
        LocalDate date = LocalDate.now();
        String dateFormat = DateTimeFormatter.ofPattern("yyyy\\MM\\dd").format(date);
        File dir = new File("C:\\dev\\workspace\\01_java-study\\taeho-java-workspace\\13_io\\"+ dateFormat);
//        File dir = new File("C:\\dev\\workspace\\01_java-study\\taeho-java-workspace\\13_io\\"+ year + "\\" + month + "\\" + day);
        if (!dir.exists()) {
            dir.mkdirs();
        }

    }
}
