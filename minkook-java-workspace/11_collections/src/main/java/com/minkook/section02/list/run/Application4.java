package com.minkook.section02.list.run;

import com.minkook.section02.list.dto.Music;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application4 {
    public static void main(String [] args){
        List<String> stringList = Arrays.asList("banana","apple","orange","mango","grape");

        System.out.println("정렬전 stringList: " + stringList);

        // collections.sort(list<T> list)
        Collections.sort(stringList);
        System.out.println("정렬 후: " + stringList);

        System.out.println("=================================================================");

        List<Integer> integerList = Arrays.asList(7,30,12,1,23,11);
        System.out.println("정렬 전 integerList " + integerList);

        Collections.sort(integerList);
        System.out.println("정렬 후 integerList" + integerList);

        System.out.println("=================================================================");

        List<Music> musicList = Arrays.asList(new Music("술이 달다","에픽하이")
                                             ,new Music("저 밤","양다일")
                                             ,new Music("잊혀지다", "정키")
                                             ,new Music("꺼내본다","김나영")
                                             );
        System.out.println("정렬전 musicList: " + musicList);

        //Collections.sort(메소드 호출시 인자로 전달하는 리스트 내의 모든 요소 클래스들에는 Comparable 인터페이스 구현되어있어야됨)
        //내부적으로 sort메소드 수행시 리스트 내의 요소들 간에 comparteTo  메소드 실행되면서 비교되고 순서가 바뀌게 되어있음
        Collections.sort(musicList);
        System.out.println("정렬후 musicList: " + musicList);

        //매번 각기 다른 정렬기준을 제시하고자 할 경우

        //*Collections.sort(List list,Compartor c) : 인자로 전달된 리스트 내의 요소들을 인자로 전달된 Comparator 클래스 내의 compare 메소드를 통해 비교하여 정렬)
    }
}
