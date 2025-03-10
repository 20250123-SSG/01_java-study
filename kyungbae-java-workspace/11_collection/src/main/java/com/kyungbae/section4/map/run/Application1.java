package com.kyungbae.section4.map.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    // Map Collection
    public static void main(String[] args) {

        // 학생 한명 정보 담기
        Map<String, Object> stu = new HashMap<>();

        // put(K key, V value) : 전달된 key-value를 map에 저장
        stu.put("name", "홍길동");
        stu.put("age", 10);
        stu.put("height", 140.3);
        stu.put("kor", 100);
        stu.put("eng", 80);
        stu.put("kor", 60);

        System.out.println(stu);

        // get(Object key) : 전달된 key 정보의 value를 V 타입으로 반환
        System.out.println(stu.get("name"));
        System.out.println(stu.get("age"));

        double height = (double)stu.get("height"); // 반환은 Object이므로 다운캐스팅
        System.out.println(height);

        // Map.of (K k1, V v1, K k2, V v2,...)
        Map<String, Object> stu2 = Map.of("name", "홍길순", "age", 10, "height", 132.1);
        System.out.println(stu2);

        // Map 내의 모든 key-value 순회 가능
        // 순차접근 방법1. keySet() : Map내의 Key들만 따로 담기는 Set 반환
        Set<String> keySet = stu2.keySet(); // Key들의 집합
//        for(String str : keySet){
//            System.out.println(stu2.get(str));
//        }
        Iterator<String> itKey = keySet.iterator();
        while (itKey.hasNext()) {
            String key = itKey.next();
            Object value = stu2.get(key);
            System.out.println("key= " + key + ", value= " + value);
        }
        System.out.println("===============================");

        // 순차접근 방법2. entrySet() : Map내의 key value 세트가 Entry 타입으로 담겨있는 Set 반환
        Set<Map.Entry<String, Object>> entrySet = stu2.entrySet();
        // entrySet() => key와 value를 key=value 식으로 가진다.
        // => 똑같은 타입을 만들어줘야 하니까 Entry 출력값에 원본과 같은 <String, Object> 넣어주기
        Iterator<Map.Entry<String, Object>> itEntry = entrySet.iterator();
        while(itEntry.hasNext()){
            Map.Entry<String, Object> entry = itEntry.next();

            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key= " + key + ", value= " + value);
        }




    }
}
