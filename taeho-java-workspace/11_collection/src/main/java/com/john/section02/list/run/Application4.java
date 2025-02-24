package com.john.section02.list.run;

import com.john.section02.comparator.AscendingTitle;
import com.john.section02.comparator.DescendingTitle;
import com.john.section02.list.dto.Music;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("banana", "apple", "orange", "grape", "pineapple");
        System.out.println(stringList);

        Collections.sort(stringList);
        System.out.println(stringList);

        System.out.println("====================");

        List<Integer> integerList = Arrays.asList(1, 8, 5, 3, 4);
        System.out.println(integerList);

        Collections.sort(integerList);
        System.out.println(integerList);

        System.out.println("====================");

        List<Music> musicList = Arrays.asList(new Music("오늘은", "도레미")
                                            ,new Music("아니", "켄트 벡")
                                            ,new Music("노래명", "김진짜")
                                            ,new Music("기억", "아아"));

        System.out.println(musicList);

        /*
            인자로 전달하는 리스트 내의 모든 요소 클래스들에는 Comparable 인터페이스가 적용
            내부적으로 sort 메서드 실행시 리시트 내의 요소들 간 compareTo 메서드가 실행되면서 비교되고 순서가 바뀌게 되어있음
         */
        Collections.sort(musicList);

        System.out.println("after sort : " + musicList);


        /*
            매번 정렬 조건을 다르게 전달
            Collections.sort(List list, Comparator c) : 인자로 전달된 리스트 내의 요소들을
                                                        인자로 전달된 Comparator 클래스 내 compare 메서드를 통해 비교정렬
         */
        Collections.sort(musicList, new AscendingTitle());
        System.out.println(musicList);

        musicList.sort(new DescendingTitle());
        System.out.println(musicList);
        
        // Comparator 를 상속받으면서 바로 생성까지 진행
        // 익명클래스(Anonymous Class) => 클래스를 구현하면서 객체를 생성
        musicList.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o2.getTitle().compareTo(o1.getTitle());
            }
        });
        System.out.println(musicList);
    }

}
