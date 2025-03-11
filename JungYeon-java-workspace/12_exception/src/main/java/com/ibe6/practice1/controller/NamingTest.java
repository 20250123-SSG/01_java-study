package com.ibe6.practice1.controller;

import javax.naming.NamingException;

public class NamingTest{
    public String[] reservedWord = {"abstract", "assert", "boolean", "break", "byte", "case"
            , "catch", "char", "class", "const", "continue", "default"
            , "do", "double", "else", "enum", "extends", "false", "final"
            , "finally", "float", "for", "if", "goto", "implements"
            , "import", "instanceof", "int", "interface", "long", "native"
            , "new", "null", "package", "private", "protected", "public"
            , "return", "short", "static", "strictfp", "super", "switch"
            , "synchronized", "this", "throw", "throws", "transient", "true"
            , "try", "void", "volatile", "while"};

    public boolean isReservedWord(String user) throws NamingException {
        for (String rw : reservedWord) {
            if(user.equals(rw)){
                throw new NamingException("변수 명명 규칙에 어긋납니다.(예약어 사용 불가능)");
            }
            // 위의 사용데이터 쪽 예약어 배열을 가지고 (복사해가세요)
            // for문을 이용하여 사용자가 입력받은 문자열(user)가 reservedWord안에 있는
            // 문자들과 대조하여 일치하는게 있을 경우
            // NamingException발생 (“변수 명명 규칙에 어긋납니다.(예약어사용불가능))
        }
        return true;
    }


    public boolean isSpecialWord(String user) throws NamingException {
        for (int i = 0; i < user.length(); i++) {
            char c = user.charAt(i);
            if(!Character.isLetterOrDigit(c) && c != '$' && c != '_'){
                throw new NamingException("변수 명명규칙에 어긋납니다. (영문자와 ‘_’, ‘$’, 숫자 사용가능)");
            }
        }
        return true;

    }

        // for문을 이용하여 사용자가 입력받은 문자열(user)에
        // 영문자(대소문자모두)와 특수문자($, _), 숫자 외의 문자가 있을 경우
        // NamingException발생(“변수 명명규칙에 어긋납니다.(영문자와 ‘_’, ‘$’, 숫자 사용가능))


    public boolean isNumFirst(String user) throws NamingException {
        char c = user.charAt(0);
        if (Character.isDigit(c)) {
            throw new NamingException("변수 명명규칙에 어긋납니다.(맨 앞 숫자 불가능)");
        }
        // 사용자가 입력한 문자열(user)의 첫번째 값이 숫자일 경우
        // NamingException발생(“변수 명명규칙에 어긋납니다.(맨 앞 숫자 불가능))
        return true;
    }
}
