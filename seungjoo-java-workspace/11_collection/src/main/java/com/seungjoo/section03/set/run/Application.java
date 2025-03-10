package com.seungjoo.section03.set.run;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Set set = new HashSet();
        set.add("안녕");
        set.add(10);
        set.add(10.2);
        set.add("안녕");

        System.out.println(set); //순서 유지 안됨, 중복 허용 안됨

        Set<Integer> intergerSet = new HashSet();
        intergerSet.add(10);
        intergerSet.add(5);


        System.out.println("==========");


        //방법1 : 향상된 for문으로 조회
        //방법2 : 배열로 변경한 후 순회
        //stringSet.toArray
        Set<String> stringSet = new HashSet();
        stringSet.add("1");

        Object[] stringArr = stringSet.toArray();
        for (int i = 0; i < stringArr.length; i++) {
            System.out.println(stringArr[i]);

        }

        //방법3 : List로 변경한 후 순회
        //List<String> stringList = new ArrayList<>();
        //stringList.addAll(stringSet);
        List<String> stringList = new ArrayList<>(stringSet);

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));

        }
        Iterator<String> iterator = stringList.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }




    }
}
