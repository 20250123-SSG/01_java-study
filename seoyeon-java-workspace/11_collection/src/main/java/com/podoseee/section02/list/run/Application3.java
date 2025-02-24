package com.podoseee.section02.list.run;

import com.podoseee.section02.list.dto.Music;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        // 주로 List에 DTO 객체들을 담게 됨

        List<Music> list = new ArrayList<>();
        System.out.println("초기 list : " + list);

        // * add(E e) => add(Music e) ***
        list.add(new Music("오늘만 I LOVE U", "BOYNEXTDOOR"));
        list.add(new Music("2 Baddies", "NCT127"));
        list.add(new Music("Somebody", "도경수"));
        list.add(new Music("내게 오는 길", "성시경"));

        System.out.println("추가후 list : " + list);

        // * add(int index, E e) => add(int index, Music e)
        list.add(1, new Music("Over the Moon", "TXT"));
        list.add(2, new Music("Hug", "동방신기"));

        System.out.println("추가후 list : " + list);

        // * remove(int index) : 리스트 내에 특정 인덱스 위치의 요소를 제거
        // * remove(Object o)  : 리스트 내에 전달된 객체와 동일한 객체를 찾아 제거시켜줌
        list.remove(1);

        System.out.println("제거 후 list : " + list);

        // * set(int index, E e) => set(int index, Music e)
        list.set(0, new Music("아로하", "조정석"));

        System.out.println("변경후 list : " + list);

        // * size() ***
        System.out.println("list의 size : " + list.size());

        // * get(int index) : E 타입 반환 => Music 타입 반환 ***
        System.out.println("0번 인덱스 : " + list.get(0));

        Music m = list.get(1); // 만일 타입 설정을 안했다면 Object 타입으로 반환 => Music으로 다운캐스팅 해야됨
        System.out.println("1번 인덱스 : " + m);

        System.out.println("2번 인덱스 Music 객체 제목 : " + list.get(2).getTitle());

        // 1번 인덱스의 Music 객체의 가수를 "RIIZE"로 수정
        list.get(1).setArtist("RIIZE");
        System.out.println("수정 후 1번 인덱스 : " + list.get(1));
        
        System.out.println("=================================================");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("=================================================");
        for(Music mu : list){
            System.out.println(mu);
        }

        System.out.println("=================================================");

        // * subList(int fromIndex, int toIndex) : 리스트의 fromIndex부터 toIndex 이전까지의 요소들을 새로운 List에 담아 반환
        List<Music> subList = list.subList(0, 2); // 0 <=  < 2
        System.out.println("추출한 subList : " + subList);

        // * addAll(Collection c) : 기존 리스트에 인자로 전달된 컬렉션(Collection 하위, List계열|Set계열)의 데이터들을 통째로 추가시켜줌
        list.addAll(subList);
        System.out.println("추가후 list : "+ list);

        // * clear() : 리스트 내의 요소를 싹 비워줌
        list.clear();
        System.out.println("초기화 후 list : " + list);

        // * isEmpty() : 리스트가 비어있을 경우 true 반환 ***
        System.out.println("비어있나요 : " + list.isEmpty());

        System.out.println("===========================================");

        List nonTypeList = Arrays.asList(new Music("칵테일사랑", "마로니에")
                                        , new Music("Chance", "찬(Chan)")
                                        , "끝");

        System.out.println("nonTypeList : " + nonTypeList);

        // * get(int index) : Object
        Music m1 = (Music)nonTypeList.get(0); // 객체를 반환 받아 다운캐스팅해야되는 경우 발생
        System.out.println(m1);

        // 1번 인덱스 Music객체 정보 변경
        ((Music)nonTypeList.get(1)).setArtist("경서");
        System.out.println(nonTypeList.get(1));

        Music m2 = (Music)nonTypeList.get(2); // 부적절한 형변환이 진행될 수 있음 => ClassCastException 발생 여지가 있음

        /*
            ## 컬렉션 사용시 타입 지정 권장 ##
            1. 명시된 타입의 객체만 저장될 수 있도록 제한을 둘 수 있어 데이터의 안정성 확보
            2. 컬렉션에 저장된 객체에 접근시 매번 형변환하는 절차를 없앨 수 있음
         */

    }
}
