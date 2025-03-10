package com.minkook.section03.set.run;

import java.util.*;

public class Application1 {
    public static void main(String [] args){
        /*
            ## Set 컬렉션 ##
            1. 집합 형태로 데이터를 관리
            2. 순서를 유지하지 않은 채로 저장
            3. 중복된 요소를 허용하지도 않음
         */

        Set set = new HashSet();

        set.add("안녕");
        set.add(10);
        set.add(10.2);
        set.add("안녕");

        System.out.println(set); //순서 유지 안됨, 중복 허용 안됨

        System.out.println("======================================");
        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(10);
        integerSet.add(5);
        //integerSet.add(10.2);
        //integerSet.add(안녕);
        integerSet.add(1);
        integerSet.add(10);
        System.out.println(integerSet);
        //size()
        System.out.println(integerSet.size());

        Set<Integer> lotto = new HashSet<>();

        while (lotto.size() < 6){
            lotto.add((int)(Math.random() * 45 + 1));

        }
        System.out.println(lotto);

        System.out.println("======================================");
        // * set.of(E e1, E e2) : 인자로 전달된 요소들이 담겨있는 Set 반환(unmodifiable set)
        Set<String> stringSet = Set.of("java","mysql","jdbc","mybatis","spring");
        System.out.println("stringSet: " + stringSet);

        //stringSet.add("jpa"); 추가 불가
        
        //특정 값 하나만을 반환 받을 순 없고 모든 요소 순회는 가능
        //방법1: 향상된 for문 반환
        for(String str : stringSet){
            System.out.println(str);
        }
        System.out.println("======================================");
        //방법2 : 배열로 변경한 후 순회
        Object[] stringArr = stringSet.toArray();

        for(int i = 0; i<stringArr.length; i++){
            System.out.println(stringArr[i]);
        }
        System.out.println("======================================");
        //방법3 : set을 list로 변경
        List<String> stringList = new ArrayList<>();
        stringList.addAll(stringSet);

        for(int i = 0; i<stringList.size();i++){
            System.out.println(stringList.get(i));
        }

        
        //보통 사용하는 경우 => Set을 이용해 중복을 제거후 List로 변환해서 사용

        System.out.println("======================================");

        //방법4 : 반복자(Iterator) 사용
        // * iterator() 
        Iterator<String> iterator = stringList.iterator();
        // .next() : iterator 공간내의 요소 꺼내 반환(일회성)
        // .hasNext() : iterator 공간내에 요소가 있을 경우 true반환

        /*System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());*/

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
