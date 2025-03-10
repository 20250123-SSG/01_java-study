package com.inyong.section04.run;

import java.util.*;

public class Application1 {
    /*
    Map 컬랙션
    키와 값을 하나의 쌍으로 저장하는 형식
    3. 구성요소
        1) Key : 값(Vlaue)을 식별해주는 식별자의 역할 (Set 형태로 관리 => 순서유지x, 중복허용x)
        2) Value : 데이터, 중복 허용됨
        3) Entry : Key와 Value를 함께 칭함

     */

    public static void main(String[] args) {


        /*
        사용 빈도
        ArrayList > HashMap > ...

        java.util.HashMap
        Map을 구현한 하위 클래스들 중 가장 많이 사용되는 클래스
        1.2 부터
        해시 알고리즘을 사용하여 내부적으로 검색 속도가 매우 빠름
         */

        // 학생 한명 정보 담기
        Map<String, Object> stu = new HashMap<>();

        // * put(K key, V value) : 전달된 key-value을 map에 저장

        stu.put("name", "홍길동");
        stu.put("age", 10);
        stu.put("height", 140.3);
        stu.put("kor", 100);
        stu.put("eng", 100);

        System.out.println(stu); // 저장 순서 유지 x, 키 중복시 덮어씌워짐

        // * get(Object Key) : 전달된 key 정보의 value를 V타입으로 반환
        System.out.println(stu.get("name"));
        System.out.println(stu.get("age"));

        double height = (double) stu.get("height");
        System.out.println(height);

        // 조회만 할 목적
        // 인자로 전달된 key-value들이 담겨있는 Map 반환 (unmodifiable map)
        Map<String, Object> stu2 = Map.of("name", "홍길순", "age", 10, "height", 132.1);
        System.out.println("stu2" + stu2);

        // put remove replace 사용 불가

        // Map 내의 모든 key-value 순회 가능
        //방법1. keySet() : Map내의 Key들만 따로 담기는 Set 반환

        Set<String> keyset  = stu2.keySet();
        Iterator<String> itKey = keyset.iterator(); // 반복자에 담기
        while (itKey.hasNext()) {                   // 반복문으로 키 도출
            String key = itKey.next();           // 반복자로부터 키 정보 뽑기
            Object value = stu2.get(key);        // 맵으로 부터 밸류 정보 뽑기
            System.out.println("key "+ key + "value " + value);
        }

        // 방법2. entrySet() : Map내에 key-value 세트가 Entry 타입으로 담겨있는 Set 반환
        Set<Map.Entry<String, Object>> entrySet = stu2.entrySet(); // 키 + 벨류 세트의 집합

        Iterator<Map.Entry<String, Object>> itEntry = entrySet.iterator();

        while(itEntry.hasNext()){
            Map.Entry<String, Object> entry = itEntry.next();

            String key = entry.getKey();
            Object value = entry.getValue();

        }















    }
}
