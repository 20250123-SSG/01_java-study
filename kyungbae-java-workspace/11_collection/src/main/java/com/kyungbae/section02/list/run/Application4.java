package com.kyungbae.section02.list.run;

import com.kyungbae.section02.list.comparator.AscendingTitle;
import com.kyungbae.section02.list.comparator.DescendingTitle;
import com.kyungbae.section02.list.dto.Music;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("banana", "apple", "orange", "mango", "grape");
        System.out.println("정렬전 stringList= " + stringList);

        // Collections.sort(List<T> list) : 인자로 전달된 리스트 내의 요소들을 사전순으로 오름차순 정렬해줌
        Collections.sort(stringList);
        System.out.println("정렬후 stringList= " + stringList);

        System.out.println("========================================================");

        List<Integer> integerList = Arrays.asList(7, 30, 12, 1, 23, 11);
        System.out.println("정렬전 integerList= " + integerList);

        Collections.sort(integerList);
        System.out.println("정렬후 integerList= " + integerList );

        System.out.println("========================================================");

        List<Music> musicList = Arrays.asList(new Music("술이 달다", "에픽하이")
                , new Music("저 밤", "양다일")
                , new Music("꺼내먹어요", "자이언티")
                , new Music("Elements", "Arban"));

        System.out.println("정렬전 musicList= " + musicList);

        Collections.sort(musicList);
        // Collections.sort 메소드 호출시 인자로 전달하는 리스트 내의 모든 요소들에는
        // Comparable 이 구현되어있어야 함
        // 내부적으로 sort메소드 수행시 리스트 내의 요소들간에 compareTo 메소드 실행되면서 비교되고 순ㄴ서가 바뀌개 되어있음
        System.out.println("정렬후= " + musicList);

        // 매번 각기 다른 정렬기준을 제시하고자 할 경우
        /*
         Collections.sort(List, List, Comparator c):
         인자로 전달된 리스트 내의 요소들을
         인자로 전달된 Comparator 클래스 내의 compare 메소드를 통해 비교하여 정렬
         */

        Collections.sort(musicList, new AscendingTitle());
        System.out.println("제목 오름차순 정렬후 musicList= " + musicList);

//        Collections.sort(musicList, new DescendingTitle());
        // List객체.sort(Comarator c); : 위와 동일
        musicList.sort(new DescendingTitle());
        System.out.println("제목 내림차순 정렬후 musicList= " + musicList);

//        musicList.sort(new Comparator<Music>()); // interface인 Comparator의 메소드가 추상화되어 있어서 생성 불가
        // 익명클래스 (Anonymous Class) => 클래스 구현과 동시에 객체 생성
        musicList.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o2.getArtist().compareTo(o1.getArtist());
            }
        });
        System.out.println("가수 내림차순 정렬= " + musicList);

    }
}
