package com.ino.section01.generic;

public class Application {
    public static void main(String[] args) {
        Container<String> stringContainer = new Container<>();

        Container<Integer> integerContainer = new Container<>();
        integerContainer.setItem(10);
        System.out.println(integerContainer);
    }
}
