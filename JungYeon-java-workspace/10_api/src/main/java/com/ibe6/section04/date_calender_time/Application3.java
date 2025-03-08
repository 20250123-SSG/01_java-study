package com.ibe6.section04.date_calender_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Application3 {
    public static void main(String[] args) {
        /*
            ## Java.text.SimpleDateFormat ##
            1. 날짜 및 시간 정보를 내가 원하는 형식의 문자열로 변환시켜주는 클래스
            2. 작성가능 포맷
               ㄴ y : 년
               ㄴ M : 월
               ㄴ d : 일
               ㄴ E : 요일
               ㄴ h/H: 시간
               ㄴ m : 분
               ㄴ s : 초

                SimpleDateFormat sdf = new SimpleDateFormat("반영시키고자하는형식(포맷)");
                sdf.format(java.util.Date객체) : String
         */

        // java.util.Date 객체 생성 후 반영
        Date today = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E HH(hh):mm::ss");
        String dateStr = sdf.format(today);
        System.out.println(dateStr);

        // java.util.Calender 객체 생성 후 반영
        Calendar today2 = Calendar.getInstance();
//        String dateStr2 = sdf.format(new Date(today2.getTimeInMillis())); //캘린더 객체를 데이터 객체로 변환
        String dateStr2 = sdf.format(today2.getTimeInMillis()); // 밀리초 값을 전달
        System.out.println(dateStr2);


    }
}
