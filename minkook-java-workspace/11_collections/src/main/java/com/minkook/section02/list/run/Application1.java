package com.minkook.section02.list.run;

import com.minkook.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

public class Application1 {
    public static void main(String [] args){
        /*
            ## java.util.ArrayList ##
            1. 가장 많이 사용되는 컬렉션
            2. jdk 1.2부터 제공
            3. 선형 자료구조로 내부적으로 배열을 이용하야 요소를 관리
            4. 배열의 단점을 보완하기 위해 만들어짐
                크기 변경, 요소 추가, 삭제, 정렬 등이 이미 메소드로 구현되어 제공되고 있음
         */
        //ArrayList alist = new ArrayList();

        //List list = new List();
        List list = new ArrayList<>(); //다형성 적용

        // * add(E e) : 인자로 전달된 요소를 리스트 마지막 위치에 추가
        list.add(10);
        list.add(10.23);
        list.add("안녕하세요");
        list.add(10);

        // * toString() : 리스트내의 요소들을 [],"","를 이용하여 하나의 문자열로 합쳐 반환되도록 오버라이딩
        System.out.println("list: " + list);

        //순서 유지, 중복허용

        //* ad(int index , E e) : 리스트내의 인자로 전달된 인덱스 위치에 인자로 전달된 요소를 추가
        list.add(1,new Music("APT","ROSE"));
        System.out.println("list:" + list);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        //장점. 크기에 제약X, 다양한 타입저장 O 복잡한 로직 X
        //단 특정타입의 데이터만 보관되도록 제한을 두는게 좋음 (즉 타입 지정해서 써라)

        System.out.println("=======================================================");

        List<Integer> numList = new ArrayList<>();

        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);

        System.out.println("numList:" + numList);
        
        // * size() : 리스트내의 요소개수 반환
        System.out.println("numList의사이즈: " + numList.size());
        System.out.println("numList의 마지막인덱스" +(numList.size() - 1));

        for(int i = 0; i<numList.size(); i++){
            System.out.println(i + "번 인덱스: " + numList.get(i));
        }

        //문자열 저장용 리스트 생성
        List<String> seasonList = new ArrayList<>();
        seasonList.add("봄");
        seasonList.add("여름");
        seasonList.add("가을");
        seasonList.add("겨울");

        System.out.println("seasonList: " + seasonList);

        for(String str : seasonList){
            System.out.println(str);
        }

    }
}
