package com.kyungbae.section4.map.run;

import com.kyungbae.section4.map.dto.Snack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {

        Map<String, Snack> map = new HashMap<>();

        // put(K key, V value)
        map.put("다이제", new Snack("초코맛", 1500));
        map.put("칸초", new Snack("단맛", 600));
        map.put("새우깡", new Snack("짠맛", 500));

        map.put("포테이토칩", new Snack("짠맛", 500)); // value가 같은건 가능

        System.out.println(map);

        map.put("새우깡", new Snack("매운맛", 700)); // key값이 같은건 덮어씌움

        System.out.println(map);

        // get(Object key)
        Snack s = map.get("다이제"); // 스낵타입(Object key) 반환
        System.out.println(s);

        // size()
        System.out.println("몇 세트가 담겨있는지= " + map.size());

        // replace(K key, V value)
        map.replace("포테이토칩", new Snack("겁나 짠맛", 1000));
        System.out.println(map);

        // remove(Object key)
        map.remove("포테이토칩");
        System.out.println(map);

        // 순회해보기
        // 방법1. keySet()
        Set<String> set = map.keySet();

        Iterator<String> itSet = set.iterator();
        while (itSet.hasNext()){
            String key = itSet.next();
            Snack value = map.get(key);
            System.out.println("key= " + key + ", value= " + value);
        }

        // 방법2. entrySet()
        Set<Map.Entry<String, Snack>> setMap = map.entrySet();

        Iterator<Map.Entry<String, Snack>> itMap = setMap.iterator();
        while (itMap.hasNext()) {
            Map.Entry<String, Snack> entryMap = itMap.next();
            String key = entryMap.getKey();
            Snack value = entryMap.getValue();
            System.out.println("key= " + key + ", value= " + value);
        }


    }
}
