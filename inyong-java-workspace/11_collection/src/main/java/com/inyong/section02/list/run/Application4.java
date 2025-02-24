package com.inyong.section02.list.run;

import com.inyong.section02.list.comparator.AscendingTitle;
import com.inyong.section02.list.comparator.DescendingTitle;
import com.inyong.section02.list.dto.Music;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("banana", "apple", "orange", "mango");
        System.out.println(stringList);

        //* Collections.sort(List<T> list) : 인자로 전달된 리스트 내의 요소들을 사전순으로 오름차순 정렬
        Collections.sort(stringList);
        System.out.println(stringList);

        System.out.println("=================");

        List<Integer> integerList = Arrays.asList(1, 2, 34, 5, 6, 7, 190);
        Collections.sort(integerList);
        System.out.println(integerList);

        System.out.println("=================");

        List<Music> musicList = Arrays.asList(new Music("c", "d"), new Music("g", "h"), new Music("a", "b"), new Music("e", "f"));

        System.out.println(musicList);


        //Collections.sort 메소드 호출시 인자로 전달하는 리스트 내의
        // 모든 요소 클래스들에는 Comparable 인터페이스 구현되어 있어야됨
        // 내부적으로 sort 메소드 수행시 리스트 내의 요소들간에 comepareTo 메소드 실행되면서 비교되고 순서가 바뀌게 되어있음

        Collections.sort(musicList);

        System.out.println(musicList);

        //* Collections.sort(List list, comparator c) : 인자로 전달된 리스트 내의 요소들을 인자로 전달된 comparator 클래스 내의 compare
        //메소드를 통해 비교

        Collections.sort(musicList, new AscendingTitle());
        System.out.println("제목 오름차순" + musicList);

        Collections.sort(musicList, new AscendingTitle());
        System.out.println("제목 오름차순 정렬후 musicList: " + musicList);

        musicList.sort(new DescendingTitle());
        System.out.println(musicList);

        musicList.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o2.getArtist().compareTo(o1.getArtist());
            }
        });
    }
}
