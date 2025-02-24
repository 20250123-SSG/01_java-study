package com.seungjoo.section02.list.run;

import java.util.ArrayList;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);

        System.out.println(numList.size());
    }
}
