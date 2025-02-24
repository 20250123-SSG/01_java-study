package com.seungjoo.section02.list.run;

import com.seungjoo.section02.list.comparator.AscendingTitle;
import com.seungjoo.section02.list.comparator.DescendingTitle;

import java.util.*;

public class Application4 {
    public static void main(String[] args) {

        List<String> strList = Arrays.asList("banana", "apple", "orange", "grape");
        System.out.println(strList);

        System.out.println("=========");
        List<Integer> integerList = Arrays.asList(10, 2, 3, 4, 5);

        Collections.sort(integerList);
        System.out.println("정렬 후 integerList: " + integerList);



        Collections.sort(strList); //모든 요소 클래스들에는 Comparable 인터페이스 구현되어 있어야 됨.
        //내부적으로 sort메소드 수행시 리스트 내의 요소들간에 compareTo 메소드 실행되면서 비교되고 순서가 바뀌게 되어있음

//        Collections.sort(strList, new AscendingTitle());
        System.out.println();

//        strList.sort(new DescendingTitle());

        strList.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
