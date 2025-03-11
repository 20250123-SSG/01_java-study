package com.ibe6.section03.wrapper;

public class Application2 {
    public static void main(String[] args) {
        /*
            ## 문자열 => 기본자료형 ##
            문자열 값을 기본자료형으로 변경 (파싱)
         */

        byte b = Byte.parseByte("1");         //1
        short s = Short.parseShort("2");      //2
        int i = Integer.parseInt("4");        //4 **
        long l = Long.parseLong("8");         //8
        float f = Float.parseFloat("4.0f");    //4.0
        double d = Double.parseDouble("8.0");  //8.0 **
        boolean bool = Boolean.parseBoolean("true");  // true
        char c = "abc".charAt(0); // Character에는 parsing메소드 없음

        System.out.println("=======================");

        String str1 = "10";
        String str2 = "15.3";

        System.out.println(str1 + str2); // "1015.3" 문자열로 작업

        int iNum =Integer.parseInt(str1); // "10" => 10
        double dNum = Double.parseDouble(str2); // "15.3" => 15.3

        System.out.println(iNum+dNum);


    }
}
