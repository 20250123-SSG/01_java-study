package com.ino;

public class FirstApplication {

    public static void main(String[] args) {
        String str = "Hello World!";
        int num = 0;
        System.out.printf("%s %d", str, num);
        abc();
    }
    public static void abc() {
        def();
        System.out.println(2);
    }
    public static void def() {
        System.out.println("Hello World");
    }
}
