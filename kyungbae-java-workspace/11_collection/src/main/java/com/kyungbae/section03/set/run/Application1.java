package com.kyungbae.section03.set.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        // ## Set 컬렉션

        Set set = new HashSet();

        // add(E e)
        set.add("안녕");
        set.add(10);
        set.add(10.2);
        set.add("안녕");

        System.out.println("set= " + set); // 순서 유지 안됨, 중복 허용 안됨

        System.out.println("===================");

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(10);
        integerSet.add(5);
        integerSet.add(1);
        integerSet.add(10);

        System.out.println("integerSet= " + integerSet);

        // size()
        System.out.println("integerSet의 size= " + integerSet.size());

        System.out.println("=======================");

        Set<Integer> lotto = new HashSet<>();
        int count = 0;
        while (lotto.size() < 6){ // 6개의 요소가 들어올때까지
            // 랜덤으로 나오는 숫자를 입력 Set이라서 중복된 값이 들어오지 않는다
            lotto.add((int)(Math.random() * 45 + 1));
            count++;
        }
        System.out.println("lotto= " + lotto);
        System.out.println("반복수행횟수= " + count);

        System.out.println("=======================");

        // Set.of(E e1, E e2, ...) : 인자로 전달된 요소들이 담겨있는 Set 반환 (unmodifiable set)
        Set<String> stringSet = Set.of("java", "MySQL", "jdbc", "mybatis", "spring");
        // IllegalArgumentException: duplicate element: jdbc // 중복시 오류
        System.out.println("stringSet= " + stringSet);

        // UnsupportedOperationException // 수행할 수 없는 명령 오류
//        stringSet.add("jpa");

        System.out.println("=======================");

        // 특정 값 하나만을 반환받을 순 없고 모든 요소 순회는 가능
        // 방법1. 향상된 for문
        for(String str : stringSet){
            System.out.println(str);
        }
        System.out.println("--------------");

        // 방법2. 배열로 변경한 후 순회
        Object[] stringArr = stringSet.toArray();
        for (int i = 0; i < stringArr.length; i++) {
            System.out.println(stringArr[i]);
        }
        System.out.println("--------------");

        // 방법3. List로 변경한 후 순회
        List<String> stringList = new ArrayList<>(stringSet);
        for (String l : stringList){
            System.out.println(l);
        }
        // 보통 사용하는 경우 => Set을 중복제거한후 List로 변환해서 사용

        System.out.println("--------------");

        // 방법4. 반복자(Iterator) 사용
        // itherator() : 컬렉션내의 요소들을 Iterator 공간에 담아 반환
        Iterator<String> iterator = stringSet.iterator();

        // Iterator객체.next() : Iterator 공간내의 요소 꺼내 반환 (제거 진행)
        // Iterator객체.hasNext() : Iterator 공간내에 요소가 있을경우 true 반환
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
