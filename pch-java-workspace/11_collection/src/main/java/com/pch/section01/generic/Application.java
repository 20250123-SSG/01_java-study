package com.pch.section01.generic;

public class Application {
    public static void main(String[] args) {

        //String 보관
        Container<String> strContainer = new Container<>();
        strContainer.setItem("안녕하셈");
        System.out.println(strContainer);

        //int 보관
        // Container<int> intContainer = new Container<>(); // 불가능
        Container<Integer> intContainer = new Container<>();
        intContainer.setItem(1);
    }
}
