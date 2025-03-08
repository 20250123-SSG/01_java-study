package com.ibe6.section04.date_calender_time;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Application2 {
    public static void main(String[] args) {
        /*
            ## java.util.Calender ##
            1. JDK 1.1에 Date 클래스의 대안으로 나옴
            2. 날짜 및 시간에 대한 값 기록 가능
            3. 추상클래스 => 객체 생성 불가
               국가별, 시간대별로 구체화시켜둔 하위 클래스들로 생성해서 사용(다형성)
         */
        // Calender today = new Calender();
        /*
        // 방법1. static getInstance() 메소드 호출로 생성된 하위객체 받기
        Calendar today = Calendar.getInstance();
        System.out.println(today);
        System.out.println(today instanceof GregorianCalendar);
        */

        // 방법2. 직접 GregorianCalendar 생성
        Calendar today = new GregorianCalendar();
        System.out.println(today);

        // 년, 월, 일, 시, 분, 초 정보를 get메소드로 알아올 수 있음
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH) +1;
        int date = today.get(Calendar.DATE);
        int ampm = today.get(Calendar.AM_PM); // AM일 경우 0 | PM일 경우 1
        int hour12 = today.get(Calendar.HOUR);
        int hour24 = today.get(Calendar.HOUR_OF_DAY);
        int min = today.get(Calendar.MINUTE);
        int sec = today.get(Calendar.SECOND);

        System.out.printf("%d년 %d월 %d일 %s %d(%d)시 %d분 %d초\n", year, month, date, ampm == 0? "오전":"오후"
                                                                  , hour12, hour24, min, sec);

        // ## 내가 원하는 날짜 및 시간으로 세팅 ##
        // 방법1. 현재 날짜 및 시간의 객체를 생성 => 값 수정
        Calendar cal1 = new GregorianCalendar();
        cal1.set(Calendar.YEAR,2023);
        cal1.set(Calendar.MONTH, 5); // Calender에서 월을 0(1월)~11(12월)로 취급
        cal1.set(Calendar.DATE, 11);

        System.out.println(cal1);

        // 방법2. 생성할 떄 값 전달하기
        Calendar cal2 = new GregorianCalendar(2023, Calendar.JUNE, 11);
        Calendar cal3 = new GregorianCalendar(2023, Calendar.JUNE, 11, 15, 30, 20);


        // * Calender 객체를 Date객체로 변환하기
        Date calToDate = new Date(cal3.getTimeInMillis());
        System.out.println(calToDate);


    }
}
