package com.ino.section02.list.run;

import java.util.LinkedList;

public class Application5 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("ino");
        list.add("2no");
        list.add("3m");
        list.add("4f");
        list.add("5h");
        System.out.println(list);
        list.addFirst("hi");
        list.addLast("hi");
    }
}
