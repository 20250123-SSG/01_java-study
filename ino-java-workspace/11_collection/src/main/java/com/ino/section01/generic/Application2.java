package com.ino.section01.generic;

import java.util.Arrays;
import java.util.List;

public class Application2 {

    public static void main(String[] args) {
        String[] sArr = {"spring", "summer", "fall", "winter"};

        List<String> sList = Arrays.asList(sArr);

        System.out.println("seasonList : " + sList);

        sList.set(0, "봄");

        System.out.println(sList);
    }
}
