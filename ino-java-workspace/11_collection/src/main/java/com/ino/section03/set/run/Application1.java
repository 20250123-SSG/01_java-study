package com.ino.section03.set.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        Set set = Set.of(1,2,3,4,5);
        for(Object i : set) {
            System.out.println(i);
        }

        Object[] intArr = set.toArray();

        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }

        List<Integer> integerList = new ArrayList<>(set);
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println("list : " + integerList.get(i));
        }

        Iterator<Integer> iterator = set.iterator();
    }
}
