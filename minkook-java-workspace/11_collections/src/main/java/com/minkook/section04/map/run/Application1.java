package com.minkook.section04.map.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args){
        /*
            ## Map 컬렉션 ##
            1. Collection 인터페이스와는 다른 저장방식을 가짐
            2. 키와 값을 하나의 쌍으로 저장하는 방식
            3. 구성요소
                1) Key : 값(value)을 식별해주는 키값
                2)
         */

        /*
            ## java.util.HashMap ##
            1. Map을 구현한 하위 클래스들 중 가장 많이 사용되는 클래스
            2. jdk 1.2부터 제공
            3. 해시 알고리즘을 사용하여 내부적으로 검색 속도가 빠름
         */

        Map<String,Object> stu = new HashMap<>();

        // *put(key,value)
        stu.put("name","홍길동");
        stu.put("age",10);
        stu.put("height",143.5);
        stu.put("kor",60);
        stu.put("eng",80);

        //get(Object key) : 전달된 key정보의 value를 Value타입으로 반환
        System.out.println(stu.get("name"));
        System.out.println(stu.get("age"));

        double height = (double)stu.get("height");
        System.out.println(height);
        System.out.println("==================================");
        // Map.of(k,k1,k2,k3,v,v1,v2..........)
        Map<String,Object> stu2 = Map.of("name","홍길순","age",10);
        //stu2.put("kor",100);
        //stu2.remove("name");
        System.out.println(stu2);

        //Map 내의 모든 key-value 순회 가능

        //방법1: keySet(): Map내의 key들만 따로 담기는 Set반환
        System.out.println("==================================");
        Set<String> keySet = stu2.keySet(); //키들의 집합

        System.out.println(keySet);

        Iterator<String> itKey = keySet.iterator();

        while (itKey.hasNext()){
            String key = itKey.next();      //반복자로부터 키 정보 뽑기
            Object value = stu2.get(key);   //반복문으로 키 도출
            System.out.println("key:" + key + " value: " + value);
            //System.out.println(stu2.get(itKey.next()));
        }

        System.out.println("==================================");
        
        //방법2: entrySet(): Map내에 key-value 세트가 Entry 타입으로 담겨있는 Set 반환
        Set<Map.Entry<String,Object>> entrySet = stu2.entrySet();

        Iterator<Map.Entry<String,Object>> itKey2 = entrySet.iterator();

        while(itKey2.hasNext()){
            Map.Entry<String,Object> entry = itKey2.next();
            String key = entry.getKey();        //반복자로부터 키 정보 뽑기
            Object value = entry.getValue();    //반복문으로 키 도출
            System.out.println("key:" + key + " value: " + value);
            //System.out.println(stu2.get(itKey.next()));
        }






    }
}
