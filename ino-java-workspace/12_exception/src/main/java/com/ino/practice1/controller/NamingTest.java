package com.ino.practice1.controller;

import com.ino.practice1.exception.NamingException;

public class NamingTest {
    public NamingTest() {
    }

    public boolean isReservedWord(String user) {
        String[] reservedWord = {"abstract", "assert", "boolean", "break", "byte", "case"
                , "catch", "char", "class", "const", "continue", "default"
                , "do", "double", "else", "enum", "extends", "false", "final"
                , "finally", "float", "for", "if", "goto", "implements"
                , "import", "instanceof", "int", "interface", "long", "native"
                , "new", "null", "package", "private", "protected", "public"
                , "return", "short", "static", "strictfp", "super", "switch"
                , "synchronized", "this", "throw", "throws", "transient", "true"
                , "try", "void", "volatile", "while"};
        for (int i = 0; i < reservedWord.length; i++) {
            if (reservedWord[i].equals(user)) {
                throw new NamingException("NamingException발생(변수 명명 규칙에 어긋납니다.(예약어사용불가능))");
            }
        }
        return true;
    }

    public boolean isSpecialWork(String user) {
        String limit = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ($_)1234567890";
        for (int i = 0; i < user.length(); i++) {
            if (!limit.contains(String.valueOf(user.charAt(i)))) {
                throw new NamingException("NamingException발생(“변수 명명규칙에 어긋납니다.(영문자와 ‘_’, ‘$’, 숫자 사용가능))");
            }
        }
        return true;
    }

    public boolean isNumFirst(String user) {
        if(Character.isDigit(user.charAt(0))) {
            throw new NamingException("NamingException발생(“변수 명명규칙에 어긋납니다.(맨 앞 숫자 불가능))");
        }
        return true;
    }
}

