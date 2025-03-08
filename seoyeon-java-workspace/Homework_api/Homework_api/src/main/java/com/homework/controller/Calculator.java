package com.homework.controller;

import com.homework.common.DateCalculator;
import com.homework.common.MathCalculator;
import com.homework.common.StringCalculator;
import com.homework.dto.FoodShop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
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
            /**
             * 1. LocalDateTime을 이용하여 현재 날짜 및 시간의 정보를 얻어 출력하는 메소드
             *    단, "2024-01-04 17:30:05"  과 같은 형식으로 출력될 수 있도록 하시오.
             *    (toString, replace, substring, indexOf 메소드 모두 사용하여 푸시오)
             */
            LocalDateTime dateTime = LocalDateTime.now();
            System.out.println(dateTime);

        }

        @Override
        public Calendar makeCalendar(String year, String month, String date) {
            return null;
        }

        @Override
        public void printFormat(Calendar calc) {

        }

        @Override
        public boolean isLeapYear(int year) {
            return false;
        }

        @Override
        public long leapDate(int startYear, int endYear) {
            return 0;
        }

        @Override
        public int sumString(String num1, String num2) {
            return 0;
        }

        @Override
        public int minusString(String num1, String num2) {
            return 0;
        }

        @Override
        public int findCharCount(String str, char ch) {
            return 0;
        }

        @Override
        public int selectTokenCount(String str) {
            return 0;
        }

        @Override
        public String toSpaceUpper(String str) {
            return "";
        }

        @Override
        public FoodShop[] csvFormat() {
            return new FoodShop[0];
        }
    }
