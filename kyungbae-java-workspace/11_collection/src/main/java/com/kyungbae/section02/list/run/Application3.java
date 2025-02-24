package com.kyungbae.section02.list.run;

import com.kyungbae.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {

        // 주로 List에 DTO객체들을 담게됨
        List<Music> list = new ArrayList<>();
        System.out.println("초기 list= " + list);

        // add(E e) ** => add(Music e)
        list.add(new Music("Good Bye", "박효신"));
        list.add(new Music("이밤", "양다일"));
        list.add(new Music("서울의달", "김건모"));
        System.out.println("추가 후 list= " + list);

        // add(int index, E e) => add(int index, Music e)
        list.add(1, new Music("아름다운밤", "울랄라세션"));
        System.out.println("추가 후 list= " + list);

        // remove(int index) : 리스트 내에 특정 인덱스 위치의 요스를 제거
        // remove(Object o)  : 리스트 내에 전달된 객체와 동일한 객체를 찾아 제거시켜줌
        list.remove(2);
        System.out.println("제거 후 list= " + list);

        // set(int index, E e)
        list.set(0, new Music("E", "epic"));
        System.out.println("변경 후 list= " + list);

        // size() **
        System.out.println("list의 size= " + list.size());

        // get(int index) ** : E 타입 반환 => Music 타입 반환
        System.out.println("0번 인덱스= " + list.get(0));

        Music m = list.get(1); // 타입 설정을 안했다면 Object 타입으로 반환 => Music으로 다운캐스팅 해야됨
        System.out.println("1번 인덱스= " + m);

        System.out.println("2번 인덱스 Misic 객체 제목= " +list.get(2).getTitle());

        // 1번 인덱스의 Music객체의 제목 수정
        list.get(1).setTitle("막걸리나");
        System.out.println("수정 후 1번 인덱스= " + list.get(1));

        System.out.println("================================================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("================================================");
        for (Music music : list){
            System.out.println(music);
        }
        System.out.println("================================================");

        // subList(int fromIndex, int toIndex) : 리스트의 fromIndex부터 toIndex 이전까지의 요소들을 새로운 List에 담아 반환
        List<Music> subList = list.subList(0,2); // 0 <= subList < 2
        System.out.println("추출한 subList= " + subList);

        // addAll(Collection c) : 기존 리스트에 인자로 전달된 컬렉션(Collection 하위, List|Set)의 데이터들을 통채로 추가시켜줌
        list.addAll(subList);
        System.out.println("추가 후 list= " + list);

        // clear() : 리스트 내의 요소를 싹 비워줌
        list.clear();
        System.out.println("초기화 후 list= " + list);

        // isEmpty() ** : 리스트가 비어있을 경우 true 반환
        System.out.println("비어있는지= " + list.isEmpty());

        System.out.println("================================================");

        List nonTypeList = Arrays.asList(new Music("술이 달다", "에픽하이")
                , new Music("이 밤", "양다일")
                , "끝");

        System.out.println("nonTypeList= " + nonTypeList);

        // get(int index) : Object 반환
        Music m1 = (Music)nonTypeList.get(0); // 다운캐스팅해야되는 경우 발생
        System.out.println(m1);

        // 1번 인덱스 Music객체 정보 변경
        ((Music)nonTypeList.get(1)).setTitle("저 밤");
        System.out.println(nonTypeList.get(1));

        Music m2 = (Music)nonTypeList.get(2); // 부적절한 형변환 발생 => ClassCastException 오류

        /*
            # 컬랙션 사용 시 타입 지정 권장
         */

    }
}
