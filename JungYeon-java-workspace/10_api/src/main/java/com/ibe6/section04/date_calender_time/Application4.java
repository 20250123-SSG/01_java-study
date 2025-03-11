package com.ibe6.section04.date_calender_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Application4 {
    public static void main(String[] args) {
        /*
            ## java.time.LocalDate|LocalTime|LocalDateTame ##
            1. JDK 1.8 이상부터 사용 가능한 클래스
            2. Date, Calendar을 보완한 클래스
            3. 날짜만, 시간만, 둘다의 정보를 가질 수 있음
            4. 객체 생성 불가
               => Static now() : 현재 날짜 및 시간 정보를 가져옴
               => Static of()  : 특정 날짜 및 시간 정보를 세팅 가능
         */

        LocalDate date1 = LocalDate.now();
        System.out.println(date1);

        System.out.println(date1.getYear());
        System.out.println(date1.getMonth());
        System.out.println(date1.getMonthValue());
        System.out.println(date1.getDayOfMonth());

        LocalDate date2 = LocalDate.of(2024, 6, 11);
        System.out.println(date2);

        System.out.println("==========");

        LocalTime time1 = LocalTime.now();
        System.out.println(time1);
        System.out.println(time1.toString().substring(0, 8));

        // getHour(), getMinute(), getSecond(), getNano()

        LocalTime time2 = LocalTime.of(13, 30, 20);
        System.out.println(time2);

        System.out.println("==========");

        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1); // 년-월-일T시:분:초.나노초
        System.out.println(dateTime1.toString().replace("T", " "));

        LocalDateTime dateTime2 = LocalDateTime.of(2024, 6, 11, 13, 0, 15);
        System.out.println(dateTime2);

        // java.time.DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 HH(hh)시 mm분 ss초");
        String nowStr = dtf.format(dateTime1);
        System.out.println(nowStr);

    }
}
