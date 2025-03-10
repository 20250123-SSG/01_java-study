package com.minkook.section02.list.run;

import com.minkook.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application3 {
    public static void main(String [] args){
        //주로 List에 DTO객체들을 담게됨
        List<Music> list = new ArrayList<>();
        System.out.println("초기 list:" + list);

        // * add(E e_ => add(Music e)
        list.add(new Music("Good Bye","박효신"));
        list.add(new Music("이 밤","양다일"));
        list.add(new Music("잊혀지다","정키"));

        System.out.println("추가후 list: " + list);

        list.add(1,new Music("진심이 담긴 노래","케이시"));
        System.out.println("추가후 list: " + list);

        // * remove(int index) : 리스트 내에 특정 인덱스 위치의 요소를 제거
        // * remove(Object o) : 리스트 내에 전달된 객체와 동일한 객체를 찾아 제거시켜줌
        list.remove(1);

        System.out.println("제거후 list: " + list);

        list.set(0,new Music("술이달다","에픽하이"));
        System.out.println("변경후 list: " + list);

        System.out.println("list의 size: " + list.size());

        System.out.println("0번 인덱스: " + list.get(0));
        
        Music m = list.get(1); //만일 타입 설정을 안했다면 Object 타입으로 반환 => Music으로 다운캐스팅 해야됨
        System.out.println("1번 인덱스: " + m);

        System.out.println("2번 인덱스 Music 객체 제목: " + list.get(2).getTitle());

        list.get(1).setTitle("저 밤");
        System.out.println("수정후 1번 인덱스: " + list.get(1));

        System.out.println("==============================================");
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("==============================================");
        for(Music music : list){
            System.out.println(music);
        }
        System.out.println("==============================================");
        // * subList(int fromindex ,int toIndex) : 리스트에 from 부터 toIndex이전까지의 요소들을 새로운 List에 담아 반환
        List<Music> subList = list.subList(0,2);
        System.out.println("추출한 subList: " + subList);

        // addAll(Collection c) : 기존 리스트에 인자로 전달된 컬렉션(Collection 하위, List계열 | Set계열)의 데이터들을 통채로 추가시켜줌
        list.addAll(subList);
        System.out.println("추가후 list: " + list);

        // clear() : 리스트 내의 요소를 싹 비워줌
        list.clear();
        System.out.println("초기화후 list" + list);

        // * isEmpty() : 리스트가 비어있을 경우 true 반환

        System.out.println("비어있나요: " + list.isEmpty());

        System.out.println("==============================================");

        List nonTypeList = Arrays.asList(new Music("술이 달다","에픽하이")
                                        ,new Music("이 밤","양다일")
                                        ,"끝");

        System.out.println(nonTypeList);

        Music m1 = (Music)nonTypeList.get(0);
        System.out.println(m1);
        ((Music)nonTypeList.get(1)).setTitle("저 밤");
        System.out.println(nonTypeList.get(1));
        
        Music m2 = (Music)nonTypeList.get(2); //부적절한 형변환이 진행될 수 있음 => classCastException 발생여지
        
        /*
            컬렉션 사용시 유의사항
         */
        
        


    }
}
