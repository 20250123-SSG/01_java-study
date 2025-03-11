package com.homework.controller;


import com.homework.common.DateCalculator;
import com.homework.common.MathCalculator;
import com.homework.common.StringCalculator;
import com.homework.dto.FoodShop;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.StringTokenizer;


public class Calculator implements DateCalculator, MathCalculator, StringCalculator {
    @Override
    public void printNowDateTime() {
        /**
         * 1. LocalDateTime을 이용하여 현재 날짜 및 시간의 정보를 얻어 출력하는 메소드
         *    단, "2024-01-04 17:30:05"  과 같은 형식으로 출력될 수 있도록 하시오.
         *    (toString, replace, substring, indexOf 메소드 모두 사용하여 푸시오)
         */
        LocalDateTime dateTime1 = LocalDateTime.now();
        String dateTimeStr = dateTime1.toString().replace("T", " ");
        int dateTimeIndex = dateTimeStr.indexOf(".");
        String dateNow = dateTimeIndex == -1 ? dateTimeStr : dateTimeStr.substring(0, dateTimeIndex);
        System.out.println(dateNow);
    }


    @Override
    public Calendar makeCalendar(String year, String month, String date) {
        /**
         * 2. 전달받은 년도,월,일(문자열형태)을 가지고 Calendar객체에 반영시켜 반환하는 메소드
         *
         * @param year
         * @param month
         * @param date
         * @return
         */


        int myear = Integer.parseInt(year);
        int mmonth = Integer.parseInt(month) - 1;
        int mdate = Integer.parseInt(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(myear, mmonth, mdate);

        return calendar;
    }


    @Override
    public void printFormat(Calendar calc) {
        /**
         * 3. 전달받은 Calendar 객체를 가지고 아래와 같은 형식으로 출력하는 메소드
         *    "2024-01-04 목요일"
         *
         * @param calc
         */
        int year = calc.get(Calendar.YEAR);
        int month = calc.get(Calendar.MONTH) + 1;
        int day = calc.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E요일", Locale.KOREAN);
        String dateStr = sdf.format(calc.getTime());
        System.out.println(dateStr);

    }

    @Override
    public boolean isLeapYear(int year) {
        /**
         * 4. 전달된 년도가 윤년인지 여부값을 반환하는 메소드
         *
         * * 윤년이란?
         *   년도가 4의 배수여야하고 뿐만아니라 400의 배수이거나 100의배수가 아닌 경우를 의미한다.
         *   윤년일때는 2월이 29일까지 있다.
         *
         *   따라서 윤년은 1년이 총 366일이고
         *   그 외의 평년은 1년이 총 365일이다.
         *
         * @param year
         * @return
         */
        if(year % 4 == 0){
            if(year % 400 == 0 || year % 100 != 0){
                return true;
            }
        }
        return false;

    }

    @Override
    public long leapDate(int startYear, int endYear) {
        /**
         * 5. 전달된 시작년도의 1월 1일부터 끝년도의 12월 31일까지의 총 일수를 계산해서 반환하는 메소드
         *
         *    * 참고사항
         *      윤년일 경우는 1년이 366일
         *      평년일 경우는 1년이 365일
         *
         *    이때, 특정년도가 윤년인지 비교하는 구문을 사용해야될 경우 위의 isLeapYear 메소드를 호출시켜서 비교하시오.
         *
         * @param startYear
         * @param endYear
         * @return
         */

        int sumYear = 0;
        for (int year = startYear; year <= endYear; year++) {
            // 특정 상황에서는 366일을 더하고 365일을 더해야함. 어떻게????
            if (isLeapYear(year)) {
                sumYear += 366;
            }else {
                sumYear += 365;
            }
        }
        return sumYear;
    }

    @Override
    public int sumString(String num1, String num2) {
        /**
         * 1. 전달받은 두 숫자(문자열형태)의 덧셈 결과를 구해 반환하기
         *    단, 실수값형태의 문자열일 경우 덧셈 연산 후 반올림해서 반환하기
         *
         * @param num1
         * @param num2
         * @return
         */


        double dNum1 = Double.parseDouble(num1);
        double dNum2 = Double.parseDouble(num2);

        double sum = dNum1 + dNum2;

        return (int) Math.round(sum);
    }

    @Override
    public int minusString(String num1, String num2) {
        /**
         * 2. 전달받은 두 숫자(문자열형태)의 차(절대값)를 구해 반환하기
         *    단, 실수값형태의 문자열일 경우 -1을 바로 반환할 것
         *
         * @param num1
         * @param num2
         * @return
         */

        if( num1.contains(".") || num2.contains(".") ){
            return -1;
        }
        int iNum1 = Integer.parseInt(num1);
        int iNum2 = Integer.parseInt(num2);

        return Math.abs(iNum1 - iNum2);
    }

    @Override
    public int findCharCount(String str, char ch) {
        /**
         * 1. 전달받은 문자열로부터 전달된 문자가
         *    대소문자 상관없이 몇 개있는지 반환하는 메소드
         *
         * @param str aPple
         * @param ch   p
         * @return
         */

        String upperStr = str.toUpperCase();
        String upperCh = str.toUpperCase();
        int count = 0;
        for(int i=0; i<upperStr.length(); i++) {
            if (upperStr.charAt(i) == upperCh.charAt(0)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public int selectTokenCount(String str) {
        /**
         * 2. 전달받은 문자열을 공백을 기준으로 분리시켰을 때
         *    몇 개의 문자열이 있는지 반환하는 메소드
         *    (StringTokenizer를 이용해서 푸시오)
         *
         * @param str
         * @return
         */
        StringTokenizer stn = new StringTokenizer(str, " ");

        return stn.countTokens();
    }

    @Override
    public String toSpaceUpper(String str) {
        /**
         * 3. 전달받은 문자열에 공백을 기준으로
         *    매 단어 앞글자마다 대문자로 처리하여 반환하시오
         *    (split메소드, StringBuilder 이용해서 푸시오)
         *    	ex) "apple kiwi strawberry" 가 전달 됐을 경우
         *     	 => "Apple KiwiStrawberry" 가 반환되어야됨
         *
         * @param str
         * @return
         */


        StringBuilder sb = new StringBuilder();

        String[] arr = str.split(" "); //[ap ,ki,st]

        for(int i=0; i < arr.length; i++){
            Character.toUpperCase(arr[i].charAt(0)); // a >>A
            arr[i].substring(1); // pple
            sb.append( Character.toUpperCase(arr[i].charAt(0)));
            sb.append(arr[i].substring(1));
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public FoodShop[] csvFormat() {
        return new FoodShop[0];
    }

    // 해당 클래스안에 정의해야되는 메소드들은 현재
	// StringCalculator, MathCalculator, DateCalculator 인터페이스에 추상메소드로 정의되어있다.
	// 세 인터페이스를 구현하는 클래스로 완성하시오. 즉, implements 하여 해당 각 메소드를 완성하시오.

	
	public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.printNowDateTime();
    }
	
}
