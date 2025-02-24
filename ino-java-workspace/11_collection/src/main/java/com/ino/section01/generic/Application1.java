package com.ino.section01.generic;

import com.ino.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {
        List aList = new ArrayList<>();

        aList.add(10);
        aList.add(10.2);
        aList.add("hello");
        aList.add(1, new Music("APT", "ROSE"));
        System.out.println("List: " + aList);


        List<Integer> numList = new ArrayList<>();

        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);

        System.out.println(numList);
    }
}
