package com.john.section3.set.run;

import java.util.*;

/*
    Set
    - 집합형태로 데이터를 관리
    - 순서를 유지하지 않은 채로 저장
    - 중복된 요소를 허용하지 않음 (null 포함)
    
    HashSet
    - Set을 구현한 하위 클래스들 중 가장 많이 사용되는 클래스
    - 해시 알고리즘을 사용하여 내부 검색속도가 빠름
    - 중복 요소 판별 시, 해당 요소의 hasCode로 범위를 추리고 equals로 요소간 동등비교 수행

    
    Iterator
    - 컬렉션에 저장된 요소들을 순회하고 접근하기 위한 인터페이스
    - 간단한 메서드 만으로 컬렉션의 요소를 쉽게 가져올 수 있음
    - 단 처음부터 끝까지 단방향으로만 가능하고, 일회성으로 사용됨.
    - 값 변경 혹은 추가 불가능 
   
 */
public class Application {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add(10);
        set.add("hello");
        set.add(99.3);

        System.out.println("set" + set);

        Set<Integer> integerSet = new HashSet();
        integerSet.add(10);
        integerSet.add(20);
        integerSet.add(10);
        System.out.println("integerSet" + integerSet);
        System.out.println("integer set size: " + integerSet.size());

        Set<Integer> lotto = new HashSet();
        while (lotto.size() < 6) {
            lotto.add((int)(Math.random() * 45) + 1);
        }
        System.out.println("lotto" + lotto);
        System.out.println("===============");

//        Set.of(E e1, E e2, ...): 인자로 전달된 요소들이 담겨있는 Set반환 (unmodifiable set)
        Set<String> stringSet = Set.of("JAVA", "Python", "C", "Mysql", "Oracle");
        System.out.println("stringSet" + stringSet);

//        stringSet.add("JPA"); 추가 불가
        System.out.println("===============");

        // 특정값 하나를 반환받을 수 없지만, 모든 요소 순회는 가능
        for(String str : stringSet) {
            System.out.println(str);
        }
        System.out.println("===============");

        stringSet.toArray();
        Object[] stringArr = stringSet.toArray();
        for (int i = 0; i < stringArr.length; i++) {
            System.out.println(stringArr[i]);
        }
        System.out.println("===============");

//        List<String> stringList = new ArrayList<String>();
//        stringList.addAll(stringSet);
        List<String> stringList = new ArrayList<>(stringSet);
        for (String str : stringList) {
            System.out.println(str);
        }

        // Iterable() 컬렉션 내 요소들을 Iterable 공간에 담아 반환
        Iterator<String> iterator = stringList.iterator();
        
        // Iterable.next(): Iterable 내 요소 반환
        // Iterable.hasNext(): Iterable 내 요소가 있는 경우 True
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
