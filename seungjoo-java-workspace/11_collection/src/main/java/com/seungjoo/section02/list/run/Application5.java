package com.seungjoo.section02.list.run;

import java.util.LinkedList;

public class Application5 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        list.add("캥거루");
        list.add("김말똥");
        list.add("강개순");
        list.add(1,"홍길순");

        System.out.println(list);

    }

}
