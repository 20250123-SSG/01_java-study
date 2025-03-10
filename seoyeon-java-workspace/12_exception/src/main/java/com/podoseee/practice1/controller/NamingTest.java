/*
package com.podoseee.practice1.controller;

import javax.naming.NamingException;
import java.util.Scanner;

public class NamingTest(){
    public boolean isReservedWord(String user) throws NamingException(){

        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하세요 : ");
        String user = sc.nextLine();

        String[] reservedWord = {"abstract", "assert", "boolean", "break", "byte", "case"
                , "catch", "char", "class", "const", "continue", "default"
                , "do", "double", "else", "enum", "extends", "false", "final"
                , "finally", "float", "for", "if", "goto", "implements"
                , "import", "instanceof", "int", "interface", "long", "native"
                , "new", "null", "package", "private", "protected", "public"
                , "return", "short", "static", "strictfp", "super", "switch"
                , "synchronized", "this", "throw", "throws", "transient", "true"
                , "try", "void", "volatile", "while"};

        try {
            for (String word : reservedWord) {
                if (user.equals(word)) {
                    throw new NamingException("변수 명명 규칙에 어긋납니다.(예약어사용불가능)");
                }
            }
            System.out.println("'" + user + "'는 올바른 변수명입니다.");
        }catch (NamingException e){
            System.out.println("에러 발생 : " + e.getMessage());
        }
    }

    public boolean isSpecialWord(String user) throws NamingException(){
        // for문을 이용하여 사용자가 입력받은 문자열(user)에
        // 영문자(대소문자모두)와 특수문자($, _), 숫자 외의 문자가 있을 경우
        // NamingException발생(“변수 명명규칙에 어긋납니다.(영문자와 ‘_’, ‘$’, 숫자 사용가능))
        return true;
    }

    public boolean isNumFirst(String user) throws NamingException(){
        // 사용자가 입력한 문자열(user)의 첫번째 값이 숫자일 경우
        // NamingException발생(“변수 명명규칙에 어긋납니다.(맨 앞 숫자 불가능))
        return true;
    }
}*/
