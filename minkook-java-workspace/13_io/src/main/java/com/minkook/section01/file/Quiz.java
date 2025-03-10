package com.minkook.section01.file;

import java.io.File;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Quiz {
    public static void main(String [] args){
        //실습.
        //코드 실행시점의 날짜로 디렉토리가 만들어지도록 하시오.
        //ex) C:\2025\02\07

        LocalDate date = LocalDate.now();
        System.out.println(date);
        //String [] dateArr = date.toString().split("-");
        String dateNew = date.toString().replace('-','\\');
        //String year = dateArr[0];
        //String month = dateArr[1];
        //String day = dateArr[2];
        //File dir = new File("C:\\" + year +"\\" +  month+"\\" + day);
        File dir = new File("C:\\" + dateNew);
        if(!dir.exists()){
            System.out.println(dir.mkdirs());
        }
        System.out.println(dir + " 디렉토리가 생성되었습니다.");



    }
}
