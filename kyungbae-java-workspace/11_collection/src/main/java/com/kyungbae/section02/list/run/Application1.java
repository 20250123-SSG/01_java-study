package com.kyungbae.section02.list.run;

import com.kyungbae.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        // java.util.ArrayList

        ArrayList alist = new ArrayList();

//        List list = new List(); // List는 추상클래스
        List/*<Object>*/ list = new ArrayList(); // ArrayList는 List의 하위 클래스 (다형성 적용)

        // add(E e) : 인자로 전달된 요소를 리스트 마지막 위치에 추가
//        list.add(Object e)
        list.add(10); // AutoBoxing (int -> Integer)
        list.add(10.23);
        list.add("안녕하세요");
        list.add(10);

        // toString() : 리스트 내의 요소들을 "[]", ","를 이용하여 하나의 문자열로 합쳐 반환하도록 Overriding
        System.out.println(list);
        // 순서 유지, 중복 허용

        // add(int inedx, E e) : 리스트 내의 인자로 전달된 인덱스 위치에 인자로 전달된 요소를 추가
        list.add(1, new Music("아파트", "윤수일"));
        System.out.println(list);

        // get(int index) : 리스트 내에 인자로 전달된 인덱스 위치의 요소를 E 타입으로 반환시켜주는 메소드
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }

        // 장점. 크기에 제약 없음, 다양한 타입 저장, 복잡한 로직 없음
        // 단, 특정 타입의 데이터만 보관되도록 제한을 두는게 좋음

        System.out.println("===============================================");

        // 정수 데이터 저장용 리스트 생성 (Integer 타입만)
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);

        System.out.println("numList : " + numList);

        // size() : 리스트 내의 요소 개수 반환
        System.out.println("numList의 size= " + numList.size());
        System.out.println("numList의 마지막인덱스수= " + (numList.size() - 1));

        for (int i = 0; i < numList.size(); i++) {
            System.out.println(i + "번 인덱스= " + numList.get(i));
        }

        System.out.println("===============================================");

        // 문자열 저장용 리스트 생성
        List<String> seasonList = new ArrayList<>();
        seasonList.add("봄");
        seasonList.add("여름");
        seasonList.add("가을");
        seasonList.add("겨울");

        System.out.println("seasonList= " + seasonList);

        for(String a : seasonList){ // 향상된 for문 사용 예시
            System.out.println(a);
        }

    }
}
