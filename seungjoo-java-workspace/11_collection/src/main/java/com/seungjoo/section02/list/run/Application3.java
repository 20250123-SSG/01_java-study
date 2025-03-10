package com.seungjoo.section02.list.run;

import com.seungjoo.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        //주로 List에 DTO객체들을 담게됨

        List<Music> list = new ArrayList<Music>();
        list.add(new Music("Good Bye", "박효신"));
        list.add(new Music("이 밤", "양다일"));
        list.add(new Music("잊혀지다.", "정키"));

        System.out.println(list);

        list.add(1,new Music("진심이 담긴 노래", "케이시"));

        list.remove(1);

        System.out.println(list);

        list.set(0,new Music("술이 달다", "에픽하이"));

        System.out.println("변경 후 list" + list);

        Music m = list.get(1);

        //1번 인덱스의 Music객체의 제목을 "저 밤"으로 수정
        list.get(1).setTitle("저 밤");
        System.out.println("수정 후 1번 인덱스: "  + list.get(1));


        System.out.println("========");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
        for(Music mu : list){
            System.out.println(mu);
        }

        List<Music> subList=  list.subList(0,2);
        System.out.println("추출한 subList: " + subList);


        list.addAll(subList);
        System.out.println(list);

        list.clear();
        System.out.println(list);

        System.out.println("==============");

        List nonTypeList = Arrays.asList(new Music("술이 달다", "에픽 하이")
                                        ,new Music("이 밤", "양다일")
                                        ,"끝");

        System.out.println(nonTypeList);

        Music m1 = (Music) nonTypeList.get(0); //타입을 지정해주지 않는 경우 객체를 반환받아 다운캐스팅해야되는 경우 발생

        ((Music)nonTypeList.get(1)).setTitle("저 밤");
        System.out.println(nonTypeList.get(1));































    }
}
