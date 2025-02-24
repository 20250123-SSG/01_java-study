package com.john.section02.list.run;

import com.john.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {

        List<Music> list = new ArrayList<>();
        System.out.println("list : " + list);

        list.add(new Music("Good Bye", "박효신"));
        list.add(new Music("이 밤", "양다인"));
        list.add(new Music("잊혀지다", "정키"));

        System.out.println("after list : " + list);

        list.add(1, new Music("진심이 담김 노래", "케이시"));

        System.out.println("after list add New Music : " + list);

        list.remove(1);
        System.out.println("after remove : " + list);
        
        list.set(0, new Music("아이고", "나는"));
        System.out.println("after set : " + list);

        System.out.println("list size : " + list.size());

        System.out.println("get list(0) : " + list.get(0));
        System.out.println("second music title : " + list.get(2).getTitle());

        // 타입 설정을 안했다면 Object 타입 반환
        Music music = list.get(1);
        System.out.println("music : " + music);

        list.get(1).setTitle("저저저 긴밤");
        System.out.println("after Modify list.get(1) : " + list.get(1));

        System.out.println("===================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("========For each===========");
        for (Music m : list) {
            System.out.println(m);
        }

        System.out.println("===================");
        List<Music> subList = list.subList(0, 2); //subList(start, end);
        System.out.println("subList : " + subList);

        list.addAll(subList);
        System.out.println("after add subList : " + list);

        list.clear();
        System.out.println("after clear : " + list);

        System.out.println("list empty: " + list.isEmpty());

        System.out.println("===================");

        List nonTypeList = Arrays.asList(new Music("술이 달다","에픽하이")
                                        ,new Music("오늘","밤")
                                        ,"끝");
        System.out.println("nonTypeList : " + nonTypeList);

        Music m1 = (Music)nonTypeList.get(0);
        System.out.println(m1);

        ((Music)nonTypeList.get(1)).setTitle("개밤");
        System.out.println(nonTypeList.get(1));


        // 부적절한 형변환 진행 가능성
        Music m2 = (Music)nonTypeList.get(2);

    }
}


