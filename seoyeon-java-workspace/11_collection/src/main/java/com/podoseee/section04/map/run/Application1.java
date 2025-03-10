package com.podoseee.section04.map.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    /*
            ## Map 컬렉션 ##
        1. Collection 인터페이스와는 다른 저장 방식을 가짐
        2. 키(Key)와 값(Value)을 하나의 쌍으로 저장하는 방식
        3. 구성요소
           1) Key   : 값(Value)을 식별해주는 식별자의 역할 (Set 형태로 관리 => 순서유지x, 중복허용x)
           2) Value : 데이터, 중복 허용됨
           3) Entry : Key와 Value를 함께 칭함

         */
    public static void main(String[] args) {

        /*
            ## java.util.HashMap ##
            1. Map을 구현한 하위 클래스들 중 가장 많이 사용되는 클래스
            2. JDK 1.2 부터 제공
            3. 해시 알고리즘을 사용하여 내부적으로 검색 속도가 매우 빠름

         */

        // 학생 한 명 정보 담기
        Map<String, Object> stu = new HashMap<>();

        // * put(K key, V value) : 전달된 key-value을 map에 저장
        stu.put("name", "이서연");
        stu.put("age", 23);
        stu.put("height", 157.1);
        stu.put("kor", 100);
        stu.put("eng", 80);
        stu.put("kor", 60);
        // 일회용 DTO 같은 느낌

        System.out.println(stu);    // 순서유지안됨, 키가 중복될 경우 value는 덮어씌워짐

        // * get(Object key) : 전달된 key 정보의 value를 V타입으로 반환
        System.out.println(stu.get("name"));
        System.out.println(stu.get("age"));

        double height = (double)stu.get("height"); // 단, Object로 반환되므로 강제 다운캐스팅
        System.out.println(height);

        System.out.println("==============");

        // * Map.of(K k1, V v1, K k2, V v2, ..) : 인자로 전달된 key-value들이 담겨있는 Map 반환 (unmodifiable map)
        Map<String, Object> stu2 = Map.of("name", "김수연", "age", 26, "height", 171.3);
        System.out.println(stu2);

        //stu2.put("kor", 100);
        //stu2.remove("name");
        //stu.replace("age", 20);

        // Map 내의 모든 key-value 순회 가능
        // 방법1. keySet() : Map내의 Key들만 따로 담기는 Set 반환
        Set<String> keySet = stu2.keySet();         // 1) 키들의 집합

        Iterator<String> itKey = keySet.iterator(); // 2) 반복자에 담기

        while (itKey.hasNext()){                    // 3) 반복문으로 키 도출

            String key = itKey.next();              // 반복자로부터 키 정보 뽑기
            Object value = stu2.get(key);           // 맵으로부터 밸류 정보 뽑기
            System.out.println("key : " + key + ", value : " + value);
        }

        System.out.println("=======================================");

        // 방법2. entrySet() : Map내에 key-value 세트가 Entry 타입으로 담겨있는 Set 반환
        Set<Map.Entry<String, Object>> entrySet = stu2.entrySet(); // Entry<키+밸류> 세트의 집합

        Iterator<Map.Entry<String, Object>> itEntry = entrySet.iterator();

        while(itEntry.hasNext()){
            Map.Entry<String, Object> entry = itEntry.next();

            String key = entry.getKey();
            Object value = entry.getValue();

            System.out.println("key : " + key + ", value : " + value);
        }
    }
}
