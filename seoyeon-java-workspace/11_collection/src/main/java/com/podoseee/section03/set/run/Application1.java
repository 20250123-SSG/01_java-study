package com.podoseee.section03.set.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /*
            ## Set 컬렉션 ##
            1. 집합 형태로 데이터를 관리
            2. 순서를 유지하지 않은채로 저장 (index같은 개념x)
            3. 중복된 요소를 허용하지 않음 (null도 하나만 저장됨)

            ## java.util.HashSet ##
            1. Set을 구현한 하위클래스들 중 가장 많이 사용되는 클래스
            2. JDK 1.2 부터 제공
            3. 해시 알고리즘을 사용하여 내부적으로 검색 속도가 빠름
            4. 중복 요소를 판별할때 해당 요소의 hashCode로 범위를 추리고 equals로 요소간에 동등비교를 수행함
         */

        Set set = new HashSet();

        // * add(E e)
        set.add("안녕");
        set.add(10);
        set.add(10.2);
        set.add("안녕");

        System.out.println("set: " + set);   // 순서 유지 안됨, 중복 허용 안됨

        System.out.println("==============================");

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(10);
        integerSet.add(5);
        //integerSet.add(10.3);
        //integerSet.add("안녕");
        integerSet.add(1);
        integerSet.add(10);

        System.out.println("integerSet : " + integerSet);

        // * size()
        System.out.println("integerSet의 size : " + integerSet.size());

        System.out.println("========================");

        Set<Integer> lotto = new HashSet<>();
        int count = 0;
        while(lotto.size() < 6){
            lotto.add((int)(Math.random() * 45 + 1));
            count++;
        }

        System.out.println("lotto : " + lotto);
        System.out.println("반복수행횟수 : " + count);

        System.out.println("========================");

        // * Set.of(E e1, E e2, ..) : 인자로 전달된 요소들이 담겨있는 Set 반환 (unmodifiable set)
        Set<String> stringSet = Set.of("java", "mysql", "jdbc", "mybatis", "spring");
        System.out.println("stringSet : " + stringSet);

        //stringSet.add("jpa"); // 추가 불가

        // 특정 값 하나만을 반환받을 순 없고 모든 요소 순회는 가능
        // 방법1. 향상된 for문
        for(String str : stringSet){
            System.out.println(str);
        }
        System.out.println("---------");

        // 방법2. 배열로 변경한 후 순회
        Object[] stringArr = stringSet.toArray();
        for(int i=0; i<stringArr.length; i++){
            System.out.println(stringArr[i]);
        }
        System.out.println("---------");

        // 방법3. List로 변경한 후 순회
        //List<String> stringList = new ArrayList<>();
        //stringList.addAll(stringSet);
        List<String> stringList = new ArrayList<>(stringSet);
        for(int i=0; i<stringList.size(); i++){
            System.out.println(stringList.get(i));
        }
        // 보통 사용하는 경우 => Set을 중복제거한 후 List로 변환해서 사용
        System.out.println("---------");

        // 방법4. 반복자(Iterator) 사용
        // * iterator() : 컬렉션내의 요소들을 Iterator 공간에 담아 반환
        Iterator<String> iterator = stringSet.iterator();

        // * Iterator객체.next() : Iterator 공간내의 요소 꺼내 반환
        // * Iterator객체.hasNext() : Iterator 공간내의 요소가 있을 경우 true반환

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*
            ## Iterator ##
            1. 컬렉션에 저장된 요소들을 순회하고 접근하기 위한 인터페이스
            2. 간단한 메소드만으로 컬렉션의 요소를 쉽게 가져올 수 있음
            3. 단, 처음부터 끝까지 단방향만 가능하고, 일회성으로 사용됨
               값을 변경하거나 추가가 불가능
         */
    }
}
