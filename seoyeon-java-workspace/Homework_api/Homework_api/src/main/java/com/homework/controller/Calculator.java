package com.homework.controller;

import com.homework.common.DateCalculator;
import com.homework.common.MathCalculator;
import com.homework.common.StringCalculator;
import com.homework.dto.FoodShop;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

    public class Calculator implements StringCalculator, MathCalculator, DateCalculator {

        private static final String CSV_DATA = """
        1,맘스쿡,광주광역시 동구 동계천로143,062-233-1233,향토맛집,2022-01-11
        2,옛날밥상,광주광역시 남구 용대로119번길 6,062-653-7337,향토맛집,2022-01-11
        3,송정떡갈비,광주광역시 광산구 광산로29번길 1,062-944-1439,향토맛집,2022-01-11
        4,홍춘이,광주광역시 북구 무등로180번길 9-18,062-521-7733,향토맛집,2022-01-11
        5,종가집떡갈비,광주광역시 광산구 상무대로 226,062-943-8282,향토맛집,2022-01-11
        6,광신보리밥,광주광역시 북구 두리봉길 2-1(두암동),062-264-1811,향토맛집,2022-01-11
        7,조선옥,광주광역시 남구 효덕로 103,062-654-3322,한상맛집,2022-01-11
        8,송원회관,광주광역시 북구 경양로135번길 29(신안동),062-529-3250,한상맛집,2022-01-11
        9,만선당어부의밥상,광주광역시 광산구 수완로11번길 3,062-955-5595,한상맛집,2022-01-11
        10,백년미가(유촌점),광주광역시 서구 유덕로28번길 18,062-946-3392,한상맛집,2022-01-11
    """;

        @Override
        public void printNowDateTime() {
            String now = LocalDateTime.now().toString();

            System.out.println(now
                    .replace("T", " ")
                    .substring(0, now.indexOf(".")));
        }

        @Override
        public Calendar makeCalendar(String year, String month, String date) {
            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(date));
            return cal;
        }

        @Override
        public void printFormat(Calendar calc) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEE");
            String date = sdf.format(calc.getTime());
            System.out.println(date);
        }

        @Override
        public boolean isLeapYear(int year) {
            if(year % 4 == 0){
                if(year%100 != 0 || year%100 != 0){
                    return true;
                }
            }
            return false;
        }

        @Override
        public long leapDate(int startYear, int endYear) {
            long totalDays = 0;

            for(int year = startYear; year <= endYear; year++){
                if(isLeapYear(year)){ // 윤년이면 366일 추가
                    totalDays += 366;
                } else{               // 평년이면 365일 추가
                    totalDays += 365;
                }
            }
            return totalDays;
        }

        @Override
        public int sumString(String num1, String num2) {
            int number1 = Integer.parseInt(num1);
            int number2 = Integer.parseInt(num2);
            return Math.round(number1 + number2);
        }

        @Override
        public int minusString(String num1, String num2) {
            try {
                int number1 = Integer.parseInt(num1);
                int number2 = Integer.parseInt(num2);
                return (number1 - number2);
            } catch (NumberFormatException e){
                return -1;
            }
        }

        @Override
        public int findCharCount(String str, char ch) {
            int count = 0; // count 해주기 위해 초기화
            for(int i=0; i < str.length(); i++){
                if(Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(ch)){
                    count++; // count 해주기
                }
            }
            return count; // 몇개인지 반환
        }

        @Override
        public int selectTokenCount(String str) {
            StringTokenizer st = new StringTokenizer(str);
            return st.countTokens();
        }

        @Override
        public String toSpaceUpper(String str) {
            if(str == null || str.isEmpty()){
                return str;
            }

            String[] words = str.split(" ");
            StringBuilder result = new StringBuilder();

            for(String word : words){
                if (!word.isEmpty()){
                    result.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1))
                            .append(" ");
                }
            }
            return result.toString().trim();
        }

        @Override
        public FoodShop[] csvFormat() {
            String[] rows = CSV_DATA.split("\n");
            FoodShop[] foodShops = new FoodShop[rows.length];

            for(int i=0; i<rows.length; i++){
                String[] fields = rows[i].split(",");
                foodShops[i] = new FoodShop(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        fields[3],
                        fields[4],
                        fields[5]
                        
                        /*
                            int id = fields.length > 0 ? Integer.parseInt(fields[0]) : 0;
                            String name = fields.length > 1 ? fields[1] : "Unknown";
                            String address = fields.length > 2 ? fields[2] : "Unknown";
                            String phone = fields.length > 3 ? fields[3] : "Unknown";
                            String type = fields.length > 4 ? fields[4] : "Unknown";
                            String description = fields.length > 5 ? fields[5] : "No description";

                            foodShops[i] = new FoodShop(id, name, address, phone, type, description);
                         */
                );
            }
            return foodShops;
        }
    }
