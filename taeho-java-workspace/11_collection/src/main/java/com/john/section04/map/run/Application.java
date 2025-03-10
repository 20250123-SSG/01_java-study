package com.john.section04.map.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    Map
    - Collection 인터페이스와 다르게 <Key, Value>를 쌍으로 저장하는 방식
        - Key: 값을 식별해주는 식별자의 역할, Set형태로 관리
        - Value: 데이터, 중복 허용
        - Entry: Key, Value 합해서 부르는 단어

    - HashMap: Map의 하위 클래스들 중 가장 많이 사용되는 클래스
        - 해시 알고리즘을 사용해 내부적으로 검색속도가 매우 빠름
 */
public class Application {
    public static void main(String[] args) {
        Map<String, Object> students = new HashMap<>();
        students.put("name", "John");
        students.put("age", 23);
        students.put("gender", "male");
        students.put("address", "123 Main Street");
        students.put("height", 200.5);
        students.put("weight", 93.3);

        System.out.println(students);
        // 키값이 중복되는경우 값이 덮어씌워짐
        students.put("name", "사실한국인");
        System.out.println(students);

        System.out.println("========================");
        
        // get(Object key): 전달된 key 정보의 value를 V타입으로 변환
        System.out.println(students.get("name"));
        System.out.println(students.get("age"));
        // Object타입을 강제 다운 캐스팅
        double height = (double) students.get("height");

        System.out.println("========================");
        
        // 인자로 전달된 key-value가 담긴 Map반환(unmodifiable map, 조회목적)
        // Map.of(K k1, V v1, K k2, V v2, ...)
        Map<String, Object> students2 = Map.of("name", "트롤리", "age", 23, "gender", "male", "address", "123 Main Street");
        System.out.println(students2);

        // Map 내의 모든 key-val 순회
        // case 1 : Set + Iterator
        // key가 Set으로 관리되므로 가능
        Set<String> keys = students2.keySet();
        Iterator<String> iteratorKey = keys.iterator();
        while (iteratorKey.hasNext()) {
            String key = iteratorKey.next();
            Object value = students2.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        System.out.println("========================");

        // case 2 : entrySet(): Map 내에 key - value 세트가 Entry 타입으로 담겨있는 Set 반환

        Set<Map.Entry<String, Object>> entrySet = students.entrySet();

        Iterator<Map.Entry<String, Object>> iteratorEntry = entrySet.iterator();
        while (iteratorEntry.hasNext()) {
            Map.Entry<String, Object> entry = iteratorEntry.next();

            String key = entry.getKey();
            Object value = entry.getValue();

            System.out.println("Key: " + key + ", Value: " + value);
        }

    }
}
