package com.seungjoo.practice1.controller;


import com.seungjoo.practice1.exception.NamingException;

import java.rmi.Naming;

public class NamingTest {
    public boolean isReservedWord(String user) throws NamingException {
        String[] reservedWord = {"abstract", "assert", "boolean", "break", "byte", "case"
                , "catch", "char", "class", "const", "continue", "default"
                , "do", "double", "else", "enum", "extends", "false", "final"
                , "finally", "float", "for", "if", "goto", "implements"
                , "import", "instanceof", "int", "interface", "long", "native"
                , "new", "null", "package", "private", "protected", "public"
                , "return", "short", "static", "strictfp", "super", "switch"
                , "synchronized", "this", "throw", "throws", "transient", "true"
                , "try", "void", "volatile", "while"};


        for (String word : reservedWord) {
            if (user.equals(word)) {
                throw new NamingException("변수 명명 규칙에 어긋납니다. (예약어사용불가능)");
            }


        }
        return true;
    }
        public boolean isSpecialWord(String user) throws NamingException {

            for (int i = 0; i < user.length(); i++) {
                char c = user.charAt(i);
                if (Character.isLetter(c)) continue;

                if (Character.isDigit(c)) continue;

                if (c == '-' || c == '&') {
                    continue;
                }

                throw new NamingException("변수 명명규칙에 어긋납니다.(영문자와 ‘_’, ‘$’, 숫자 사용가능");

            }
            return true;
        }

        public boolean isNumFirst(String user) throws NamingException{
                char c = user.charAt(0);
                if(Character.isDigit(c)){
                    throw new NamingException("맨 앞 숫자 불가능");
                }
                return true;
            }
    }


