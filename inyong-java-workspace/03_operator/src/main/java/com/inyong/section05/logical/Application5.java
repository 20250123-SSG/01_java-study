package com.inyong.section05.logical;

public class Application5 {
    public static void main(String[] args) {

        /*

        ## short curcuit ##
        1. && : 두 논리값 모두 true여야 최종 결과가 ture
                연산식 && 연산식
        >> && 기준으로 왼쪽 연산의 결과가 false일 경우 오른쪽의 연산은 수행되지 않음!

        2 || : 두 논리중 하나라도 true면 최종결과가 true
        >> || 기준으로 왼쪽 연산의 결과가 true일 경우 오른쪽의 연산은 수행되지 않음!
         */


        int num1 = 10;
        boolean result1 = (num1<5) && (++num1>0);
        System.out.println(num1);

        int num2 = 10;
        boolean result2 = (num2<20) && (++num2<0);
        System.out.println(num2);




    }


}
