package com.john.section02.list.run;

import com.john.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

/*
    ArrayList(1.2~)
    - 배열을 단점을 보완하기 위해 만들어짐
        => 크기 변경, 요소 추가, 삭제, 정렬등이 이미 메서드로 구현되어 제공
    - 선형 자료구조로 내부적으로 배열을 이용하여 요소를 관리
        => 인덱스를 이용하여 특정요소에 빠르게 접근 가능
    - 장점: 크기에 대한 제약이 없음, 다양한 타입 저장, 로직 구현이 필요하지 않음
        => 특정 타입의 데이터만 보관되도록 제한 권장
 */
public class Application1 {
    public static void main(String[] args) {
//        ArrayList arrList = new ArrayList();

        // 리스트별 다양한 하위타입으로 변경가능성(다형성) => ArrayList 로 지정하기 보다 List로 선언해서 관리
        List list = new ArrayList();

        // add(E e)
        list.add(10); //AutoBoxing(int => Integer)
        list.add(20.2);
        list.add("Hello");
        list.add(10);

        System.out.println(list); // 순서 유지

        // add(int index, E e)
        list.add(1, new Music("아파트","로제"));

        System.out.println(list); // 순서 유지

        // get(int index)

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        System.out.println("======================");

        List<Integer> numList = new ArrayList<>();
        numList.add(10);
        numList.add(20);
        numList.add(30);
        numList.add(40);
        numList.add(50);

        System.out.println("numList: " + numList);

        // size()
        System.out.println("numList size : " + numList.size());
        // last index = size - 1
        for (int i = 0; i < numList.size(); i++) {
            System.out.println(numList.get(i));
        }

        System.out.println("======================");

        List<String> seasonList = new ArrayList<>();
        seasonList.add("Spring");
        seasonList.add("Summer");
        seasonList.add("Autumn");
        seasonList.add("Winter");

        for (int i = 0; i < seasonList.size(); i++) {
            System.out.println(seasonList.get(i));
        }

        System.out.println("======================");

        for(String s: seasonList){
            System.out.println(s);
        }
    }
}
