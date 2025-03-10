package com.kyungbae.practice1.controller;

import com.kyungbae.practice1.exception.NamingException;

public class NamingTest {

    public NamingTest(){}

    public boolean isReservedWord(String user) throws NamingException {
        String[] reservedWord = {
                "abstract", "assert", "boolean", "break", "byte", "case"
                , "catch", "char", "class", "const", "continue", "default"
                , "do", "double", "else", "enum", "extends", "false", "final"
                , "finally", "float", "for", "if", "goto", "implements"
                , "import", "instanceof", "int", "interface", "long", "native"
                , "new", "null", "package", "private", "protected", "public"
                , "return", "short", "static", "strictfp", "super", "switch"
                , "synchronized", "this", "throw", "throws", "transient", "true"
                , "try", "void", "volatile", "while"
        };
        for(String s : reservedWord){
            if(s.equals(user)){
                throw new NamingException("변수 명명 규칙에 어긋납니다.(예약어사용불가능)");
            }
        }
        return true;
    }

    public boolean isSpecialWord(String user) throws NamingException {
        boolean isSpecialWord = false;
        for (int i = 0; i < user.length(); i++) {
            char search = user.charAt(i); // user의 문자열을 문자로 쪼개 하나씩 검증
            // 불필요한 연산을 최소화 하기 위해 많이 썻을 것으로 예상하는 순서대로 하나씩 검증 후 포함되면 스킵
            if ((search >= 'a' && search <= 'z')) { // 알파벳 소문자
                continue;
            }
            if ((search >= '0' && search <= '9')) { // 숫자
                continue;
            }
            if ((search >= 'A' && search <= 'Z')) { // 알파벳 대문자
                continue;
            }
            if ((search == '_' || search == '$')) { // 특수문자
                continue;
            }
            isSpecialWord = true;
            break;
        }
        if (isSpecialWord) { // 만약 하나도 해당되지 않을 시
            throw new NamingException("영문자와 '_', '$', 숫자 사용 가능");
        }
        return true;
    }

    public boolean isNumfirst(String user) throws NamingException {
        char firstNum = user.charAt(0);
        if (firstNum >= '0' && firstNum <= '9'){
            throw new NamingException("변수 명명규칙에 어긋납니다. (맨 앞 숫자 불가능)");
        }
        return true;
    }

}
