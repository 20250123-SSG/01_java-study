package com.seungjoo.section04.map.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();

        map.put("name", "홍길동");
        map.put("age", 10);
        map.put("height", 140.3);
        map.put("kor", 100);
        map.put("eng", 80);

        System.out.println(map.get("name"));

        double height = (Double)map.get("height"); //다운 캐스팅


        System.out.println("=====");

        Map<String, Object> map1 = Map.of("name", "홍길순", "age", 10, "height", 140.3);



        Set<String> keySet = map1.keySet(); //키들의 집합
        Iterator<String> iterator = keySet.iterator(); //반복자에 담기
        while(iterator.hasNext()){
            String key = iterator.next(); //반복자로부터 키 정보 뽑기
            Object value = map1.get(key); // 맵으로부터 벨류 정보 뽑기
            System.out.println(key  + value);
        }
        System.out.println("==========");

        Set<Map.Entry<String,Object>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Object>> entryIterator = entrySet.iterator();


        while(entryIterator.hasNext()){
            Map.Entry<String, Object> entry = entryIterator.next();

            String key = entry.getKey();
            Object value = entry.getValue();

            System.out.println("key:" + key + " value:" + value);
        }




















    }
}
