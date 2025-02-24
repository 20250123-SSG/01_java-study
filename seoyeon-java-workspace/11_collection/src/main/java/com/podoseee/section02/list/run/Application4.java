package com.podoseee.section02.list.run;

import com.podoseee.section02.list.comparator.AscendingTitle;
import com.podoseee.section02.list.comparator.DescendingTitle;
import com.podoseee.section02.list.dto.Music;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("banana", "apple", "orange", "mango", "grape");
        System.out.println("정렬전 stringList : " + stringList);

        // * Collections.sort(List<T> list) : 인자로 전달된 리스트 내의 요소들을 사전순으로 오름차순 정렬해줌
        Collections.sort(stringList);
        System.out.println("정렬후 stringList : " + stringList);

        System.out.println("==================================================================");

        List<Integer> integerList = Arrays.asList(7,  30, 12, 1, 23, 11);
        System.out.println("정렬전 integerList : " + integerList);
        Collections.sort(integerList);
        System.out.println("정렬후 integerList : " + integerList);

        System.out.println("==================================================================");

        List<Music> musicList = Arrays.asList(new Music("All For You", "쿨")
                                             , new Music("Get A Guitar", "RIIZE")
                                             , new Music("너 올 때까지", "FTISLAND")
                                             , new Music("GOOD BOY", "GD&태양")
                                             , new Music("무릎", "아이유"));

        System.out.println("정렬전 musicList : " + musicList);

        // Collections.sort 메소드 호출시 인자로 전달하는 리스트 내의
        // 모든 요소 클래스들에는 Comparable 인터페이스 구현되어있어야됨
        // 내부적으로 sort메소드 수행시 리스트 내의 요소들간에 compareTo 메소드 실행되면서 비교되고 순서가 바뀌게 되어있음
        Collections.sort(musicList);

        System.out.println("정렬후 musicList : " + musicList);

        // 매번 각기 다른 정렬기준을 제시하고자 할 경우

        // * Collections.sort(List list, Comparator c) : 인자로 전달된 리스트 내의 요소들을
        //                                               인자로 전달된 Comparator 클래스 내의 compare 메소드를 통해 비교하여 정렬
        Collections.sort(musicList, new AscendingTitle());
        System.out.println("제목 오름차순 정렬후 musicList : " + musicList);

        //Collections.sort(musicList, new DescendingTitle());
        // * List객체.sort(Comparator c) : 위와 동일
        musicList.sort(new DescendingTitle());
        System.out.println("제목 내림차순 정렬후 musicList : " + musicList);

        // * 익명클래스(Anonymous Class) => 클래스를 구현하면서 객체 생성
        musicList.sort(new Comparator<Music>(){
            @Override
            public int compare(Music o1, Music o2) {
                return o2.getArtist().compareTo(o1.getArtist());
            }
        });
        System.out.println("가수 내림차순 정렬후 musicList : " + musicList);

    }
}
