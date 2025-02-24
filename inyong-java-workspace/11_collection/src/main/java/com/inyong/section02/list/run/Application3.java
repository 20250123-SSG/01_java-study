package com.inyong.section02.list.run;

import com.inyong.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        // 주로 List에 DTO 객체들을 담게됨

        List<Music> list = new ArrayList<>();
        list.add(new Music("good bye", "박효신"));
        list.add(new Music("good bye1", "박효신1"));
        list.add(new Music("good bye2", "박효신2"));

        list.add(1, new Music("진심이 담긴", "윤겔라"));

        System.out.println(list);


        //* remove(int index) : 리스트 내에 특정 인덱스 위치의 요소를 제거
        //* remove(Object o) : 리스트 내에 전달된 객체와 동일한 객체를 찾아 제거시켜줌
        list.remove(1);
        System.out.println(list);

        list.set(0, new Music("born hater", "에픽하이"));

        System.out.println(list);

        // size()
        System.out.println("size" + list.size());

        // get(int index)
        System.out.println("0 index " + list.get(0) );

        Music m = list.get(0); // 만일 타입 설정 안했다면 object 타입으로 반환 => music으로 다운캐스팅 해야됨

        System.out.println(list.get(2).getTitle());
        list.get(1).setTitle("wwe");

        System.out.println("===============");

        // 반복문, 향상된 포문 으로 조회 가능

        for (Music mu : list) {
            System.out.println(mu);
        }
        System.out.println("===============");

        //* subList(int fromIndex, int toIndex) : 리스트의 fromIndex부터 toIndex 이전까지의 요소들을 새로운 List에 담아 반환
        List<Music> subList = list.subList(0, 2);
        System.out.println("추출한 subList"  +subList);

        // * addAll(Collection c) : 기존 리스트에 인자로 전달된 컬렉션(Collection 하위, List계열|Set계열)의 데이터들을 통채로 추가시켜줌
        list.addAll(subList);
        System.out.println("추가 List " + list );

        list.clear();
        System.out.println("초기화 List " + list );

        //* isEmpty() : 리스트가 비어있을경우 true

        System.out.println(list.isEmpty());

        System.out.println("=========");

        List nonTypeList = Arrays.asList(new Music("술이 달다", "에픽파이" ),new Music("술이 달다", "에픽파이" ), "끝");
        System.out.println(nonTypeList);

        Music m1 = (Music) nonTypeList.get(0);
        System.out.println(m1);


        // 1번 인덱스 Music 객체 정보 변경 다운캐스팅
        ((Music) nonTypeList.get(1)).setTitle("저 밤");
        System.out.println(nonTypeList.get(1));

        Music m2 = (Music) nonTypeList.get(2);

        /*
        컬렉션 사용시 타입 지정권장'
        1. 명시된 타입의 객체만 저장될 수 있도록 제한을 둘 수 있어 데이터의 안정성 확보
        2. 컬렉션에 저장된 객체에 접근시 매번 형변환 하는 절차를 없앨 수 있음

         */

    }
}
