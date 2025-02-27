package com.homework.controller;


import com.homework.common.DateCalculator;
import com.homework.common.MathCalculator;
import com.homework.common.StringCalculator;
import com.homework.dto.FoodShop;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Calculator implements DateCalculator, MathCalculator, StringCalculator {

    // 해당 클래스안에 정의해야되는 메소드들은 현재
    // StringCalculator, MathCalculator, DateCalculator 인터페이스에 추상메소드로 정의되어있다.
    // 세 인터페이스를 구현하는 클래스로 완성하시오. 즉, implements 하여 해당 각 메소드를 완성하시오.

    @Override
    public void printNowDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2025-02-23T15:57:33.813171
        // toString
        String tempNow = localDateTime.toString();
        // replace
        String now = tempNow.replace('T', ' ');
        String[] strArr = now.split(" ");
        String date = strArr[0];
        System.out.println(date);
        // indexOf
        int indexComma = strArr[1].indexOf(".");
        System.out.println(indexComma);
        // substring
        String time = strArr[1].substring(0, indexComma);
        System.out.println(time);
        System.out.println(date + " " + time);
    }

    public void printNowDateTimeTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String s = localDateTime.toString();
        System.out.println(s.split("T")[0] + " " + s.split("T")[1].split("\\.")[0] );
    }

    @Override
    public Calendar makeCalendar(String year, String month, String date) {
        Calendar calendar = Calendar.getInstance();
        // set date
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        calendar.set(Calendar.DATE, Integer.parseInt(date));
        return calendar;
    }

    @Override
    public void printFormat(Calendar calc) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE");
        String result = sdf.format(calc.getTime());
        System.out.println(result);

    }

    @Override
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? true : false;
    }

    @Override
    public long leapDate(int startYear, int endYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(startYear, Calendar.JANUARY,1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(endYear, Calendar.DECEMBER, 31);
        long diff = calendar2.getTimeInMillis() - calendar.getTimeInMillis();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffDays;
    }

    public boolean floatTypeCheck(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                return true;
            }
        }
        return false;
    }

    @Override
    public int sumString(String num1, String num2) {
        boolean floatCheck = floatTypeCheck(num1);
        boolean floatCheck2 = floatTypeCheck(num2);
        if (floatCheck || floatCheck2) {
            float x = Float.parseFloat(num1);
            float y = Float.parseFloat(num2);
            return Math.round(x + y);
        } else {
            int x = Integer.parseInt(num1);
            int y = Integer.parseInt(num2);
            return (x + y);
        }
    }

    @Override
    public int minusString(String num1, String num2) {
        boolean floatCheck = floatTypeCheck(num1);
        boolean floatCheck2 = floatTypeCheck(num2);
        if (floatCheck || floatCheck2) {
            return -1;
        } else {
            int x = Integer.parseInt(num1);
            int y = Integer.parseInt(num2);
            if (x >= y) {
                return x - y;
            } else {
                return y - x;
            }
        }
    }

    @Override
    public int findCharCount(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == Character.toLowerCase(ch)
                    || str.charAt(i) == Character.toUpperCase(ch)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int selectTokenCount(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        return st.countTokens();
    }

    @Override
    public String toSpaceUpper(String str) {
        String[] strArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        int strLength = strArr.length;
        for (int i = 0; i < strLength; i++) {
            String splitStr = "";
            if (i == (strLength - 1)) {
                splitStr = strArr[i].substring(0, 1).toUpperCase() + strArr[i].substring(1);
            } else {
                splitStr = strArr[i].substring(0, 1).toUpperCase() + strArr[i].substring(1) + " ";
            }
            sb.append(splitStr);
        }
        return sb.toString();
    }

    public String toSpaceUpperTest(String str){
        char[] charArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (i == 0){
                sb.append(Character.toUpperCase(c));
                continue;
            }
            if (charArr[i - 1] == ' '){
                sb.append(Character.toUpperCase(c));
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public FoodShop[] csvFormat() {
        String csvStr = "1,맘스쿡,광주광역시 동구 동계천로143,062-233-1233,향토맛집,2022-01-11\n"
                + "2,옛날밥상,광주광역시 남구 용대로119번길 6,062-653-7337,향토맛집,2022-01-11\n"
                + "3,송정떡갈비,광주광역시 광산구 광산로29번길 1,062-944-1439,향토맛집,2022-01-11\n"
                + "4,홍춘이,광주광역시 북구 무등로180번길 9-18,062-521-7733,향토맛집,2022-01-11\n"
                + "5,종가집떡갈비,광주광역시 광산구 상무대로 226,062-943-8282,향토맛집,2022-01-11\n"
                + "6,광신보리밥,광주광역시 북구 두리봉길 2-1(두암동),062-264-1811,향토맛집,2022-01-11\n"
                + "7,조선옥,광주광역시 남구 효덕로 103,062-654-3322,한상맛집,2022-01-11\n"
                + "8,송원회관,광주광역시 북구 경양로135번길 29(신안동),062-529-3250,한상맛집,2022-01-11\n"
                + "9,만선당어부의밥상,광주광역시 광산구 수완로11번길 3,062-955-5595,한상맛집,2022-09-09\n"
                + "10,백년미가(유촌점),광주광역시 서구 유덕로28번길 18,062-946-3392,한상맛집,2022-10-10";

        String[] shopList = csvStr.split("\n");
        FoodShop[] foodShops = new FoodShop[shopList.length];
        for (int i = 0; i < foodShops.length; i++) {
            String[] shopDetials = shopList[i].split(",");
            int shopId = Integer.parseInt(shopDetials[0]);
            String shopName = shopDetials[1];
            String address = shopDetials[2];
            String phoneNumber = shopDetials[3];
            String category = shopDetials[4];
            LocalDate localDateTime = LocalDate.parse(shopDetials[5]);
            FoodShop foodShop = new FoodShop(shopId, shopName, address, phoneNumber, category, localDateTime);
            foodShops[i] = foodShop;
        }

        return foodShops;
    }
}
