package practice1.controller;

import practice1.exception.NamingException;

import java.util.regex.Pattern;

public class NamingTest {
    private static String[] reservedWord = {"abstract", "assert", "boolean", "break", "byte", "case"
            , "catch", "char", "class", "const", "continue", "default"
            , "do", "double", "else", "enum", "extends", "false", "final"
            , "finally", "float", "for", "if", "goto", "implements"
            , "import", "instanceof", "int", "interface", "long", "native"
            , "new", "null", "package", "private", "protected", "public"
            , "return", "short", "static", "strictfp", "super", "switch"
            , "synchronized", "this", "throw", "throws", "transient", "true"
            , "try", "void", "volatile", "while"};


    public NamingTest() {
    }

    public boolean isReservedWord(String user) {
        user = user.toLowerCase();
        for (String res : reservedWord) {
            if (res.equals(user)) {
                throw new NamingException("변수 명명 규칙에 어긋납니다.(예약어사용불가능)");
            }
        }
        return true;
    }

    public boolean isSpecialWord(String user) {
        for (char token : user.toCharArray()) {
            /// 대소문자영어 + 특정 특수문자
            if (Character.isLetterOrDigit(token) || (token == '$' || token == '_')) {
                continue;
            }
            /*
            /// 숫자라면
            if (Character.isDigit(token)) {
                continue;
            }
            /// 문자라면
            if (Character.isUpperCase(token) || Character.isLowerCase(token)) {
                continue;
            }
             */
            throw new NamingException("변수 명명규칙에 어긋납니다.(영문자와 ‘_’, ‘$’, 숫자 사용가능)");
        }
//        /// 대+소문자 조합이 아닌경우 예외 - 없어됨 소문자만일수ㅇㅋ
//        if (!isContainUpperCase || !isContainLowerCase) {
//            throw new NamingException("변수 명명규칙에 어긋납니다.(대소문자 모두 포함)");
//        }
        return true;
    }

    public boolean isNumFirst(String user) {
        if (Character.isDigit(user.charAt(0))) {
            throw new NamingException("변수 명명규칙에 어긋납니다.(맨 앞 숫자 불가능)");
        }
        return true;
    }

}
