package com.homework.controller;


import com.homework.common.DateCalculator;
import com.homework.common.MathCalculator;
import com.homework.common.StringCalculator;
import com.homework.dto.FoodShop;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Calculator implements DateCalculator, MathCalculator, StringCalculator {

    // 해당 클래스안에 정의해야되는 메소드들은 현재
    // StringCalculator, MathCalculator, DateCalculator 인터페이스에 추상메소드로 정의되어있다.
    // 세 인터페이스를 구현하는 클래스로 완성하시오. 즉, implements 하여 해당 각 메소드를 완성하시오.

    @Override
    public void printNowDateTime() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(
                date.toString().replace("T", "\t")
                        .substring(0, date.toString().indexOf("."))
        );
    }

    @Override
    public Calendar makeCalendar(String year, String month, String date) {
        int intYear = Integer.parseInt(year);
        int intMonth = Integer.parseInt(month);
        int intDate = Integer.parseInt(date);
//        LocalDate cal = LocalDate.of(intYear, intMonth, intDate);

        return new GregorianCalendar(intYear, intMonth-1, intDate);
    }

    @Override
    public void printFormat(Calendar calc) {
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd E요일");
        Date date = new Date(calc.getTimeInMillis());
        System.out.println(stf.format(date));
    }

    @Override
    public boolean isLeapYear(int year) {

        boolean isLeapYear = false;
        if ((year % 4 == 0) && (year % 400 != 0) && (year % 100 != 0)){
            isLeapYear = true;
        }
        return isLeapYear;
    }

    @Override
    public long leapDate(int startYear, int endYear) {
        long sumDays = 0;
        for (int i = startYear; i <= endYear; i++) {
            if (isLeapYear(i)) {
                sumDays += 366;
            } else {
                sumDays += 365;
            }
        }
        return sumDays;
    }

    @Override
    public int sumString(String num1, String num2) {
        // 들어온 num1, num2를 int 또는 double로 변경
        return (int)Math.round(Double.parseDouble(num1) + Double.parseDouble(num2));
    }

    @Override
    public int minusString(String num1, String num2) {
        int result = 0;
        if (num1.contains(".") || num2.contains(".")) {
            result = -1;
        }else{
            result = Math.abs(Integer.parseInt(num1) - Integer.parseInt(num2));
        }
        return result;
    }

    @Override
    public int findCharCount(String str, char ch) {
        String lowCh = Character.toString(ch).toLowerCase();
        char[] chStr = str.toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i < chStr.length; i++) {
            if (chStr[i] == lowCh.charAt(0)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int selectTokenCount(String str) {
        int ct = 0;
        String retry;
        if (str.contains(" ")) {
            StringTokenizer st = new StringTokenizer(str, " ");
            ct = st.countTokens();
        }
        return ct;
    }

    @Override
    public String toSpaceUpper(String str) {
        // split(" ")
        // charAt(0) => replace(문자열) => toUpperCase
        String[] splStr = str.split(" ");
        for (int i = 0; i < splStr.length; i++) {
            char ch = (splStr[i].charAt(0));
            String fromLow = Character.toString(ch);
            String toUp = fromLow.toUpperCase();
            splStr[i] = splStr[i].replace(fromLow, toUp);
        }
//        for (String arr : splStr) {
//            char ch = (arr.charAt(0));
//            String toLow = Character.toString(ch);
//            String toUp = toLow.toUpperCase();
//            arr = arr.replace(toLow, toUp);
//        } // 안됨

        return String.join(" ", splStr);
    }

    @Override
    public FoodShop[] csvFormat() {
        String csvStr =  "1,맘스쿡,광주광역시 동구 동계천로143,062-233-1233,향토맛집,2022-01-11\n"
                + "2,옛날밥상,광주광역시 남구 용대로119번길 6,062-653-7337,향토맛집,2022-01-11\n"
                + "3,송정떡갈비,광주광역시 광산구 광산로29번길 1,062-944-1439,향토맛집,2022-01-11\n"
                + "4,홍춘이,광주광역시 북구 무등로180번길 9-18,062-521-7733,향토맛집,2022-01-11\n"
                + "5,종가집떡갈비,광주광역시 광산구 상무대로 226,062-943-8282,향토맛집,2022-01-11\n"
                + "6,광신보리밥,광주광역시 북구 두리봉길 2-1(두암동),062-264-1811,향토맛집,2022-01-11\n"
                + "7,조선옥,광주광역시 남구 효덕로 103,062-654-3322,한상맛집,2022-01-11\n"
                + "8,송원회관,광주광역시 북구 경양로135번길 29(신안동),062-529-3250,한상맛집,2022-01-11\n"
                + "9,만선당어부의밥상,광주광역시 광산구 수완로11번길 3,062-955-5595,한상맛집,2022-01-11\n"
                + "10,백년미가(유촌점),광주광역시 서구 유덕로28번길 18,062-946-3392,한상맛집,2022-01-11";

        String[] data = csvStr.split("\n");
        FoodShop[] shops = new FoodShop[data.length];

        for (int i = 0; i < data.length; i++) {
            String[] food = data[i].split(",");
            int num = Integer.parseInt(food[0]);

            // split(food[5] => 각 int열로 반환 => LocalDate에 대입
            String[] day = food[5].split("-");
            int[] days = new int[day.length];
            for (int j = 0; j < day.length; j++) {
                days[j] = Integer.parseInt(day[j]);
            }
            LocalDate date = LocalDate.of(days[0], days[1], days[2]);

            shops[i] = new FoodShop(num, food[1], food[2], food[3], food[4], date);
        }
        return shops;
    }



	
}
