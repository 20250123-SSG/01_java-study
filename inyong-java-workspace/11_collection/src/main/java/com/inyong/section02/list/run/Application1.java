package com.inyong.section02.list.run;


import com.inyong.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application1 {
    public static void main(String[] args) {
        /*
        java.util.ArrayList

        1. 가장 많이 사용되는 컬렉션
        2. JDK 1.2 부터
        3. 선형자료구조로 내부적으로 배열을 이용하여 요소를 관리 따라서 인덱스를 이용하여 배열 요소에 빠르게 접근
        4. 배열의 단점을 보완하기 위해 만들어짐
        크기 변경, 요소 추가, 삭제, 정렬 등이 이미 메소드로 구현되어 제공되고 있음
         */
        ArrayList/*<Object>*/ alist = new ArrayList();
        List list = new ArrayList(); // 다형성 적용


        list.add(10);
        list.add(10.23);
        System.out.println("list" + list);

        //* add(int index, E e) : 리스트 내의 인자로 전달된 인덱스 위치에 인자로 전달된 요소를 추가
        list.add(1, new Music("AOT", "ROSE"));
        System.out.println("list" + list);

        //* get(int index): 리스트 내에 인자로 전달되ㅏㄴ 인덱스 위치의 요소를 E타입으로 반환
        System.out.println(list.get(0));


        // 장점, 크기에 제약 x, 다양한 타입 저장 o, 복잡한 로직 x
        // 단, 특정 타입의 데이터만 보관디도록 제한을 두는게 좋음 (즉, 타입 지정해서 써라!)

        System.out.println("=====================");

        List<Integer> numList = new ArrayList<>();


        //* add
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);

        // * size() : 리스트 내의 요소 개수 반환
        numList.size();

        // 반복문, 향상된 for문 가능

    }






}
