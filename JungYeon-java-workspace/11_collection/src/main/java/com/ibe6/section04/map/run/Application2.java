package com.ibe6.section04.map.run;

import com.ibe6.section04.map.dto.Snack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {


        Map<String, Snack> map = new HashMap<>();

        // * put(K key, V value)
        map.put("다이제", new Snack("초코맛", 1500));
        map.put("칸초", new Snack("단맛", 600));
        map.put("새우깡", new Snack("짠맛", 500));

        map.put("포테이토칩", new Snack("짠맛", 500));

        System.out.println(map);

        map.put("새우깡", new Snack("매운맛", 700));

        System.out.println(map);

        // * get(Object key)
        Snack s = map.get("다이제");
        System.out.println(s);

        // * size()
        System.out.println("몇 세트가 담겨있는지: " + map.size());

        // * replace(K key, V value)
        map.replace("포테이토칩", new Snack("겁나 짠맛", 1000));
        System.out.println(map);

        // * remove(Object Key)
        map.remove("포테이토칩");
        System.out.println(map);

        // 순회해보기
        // 방법1. ketSet()
        Set<String> keySet = map.keySet();
        /*
        for(String key : keySet){
            System.out.println("key: " + key + ", value: " + map.get(key));
        }
         */
        Iterator<String> itKey = keySet.iterator();
        while (itKey.hasNext()){
            String key = itKey.next();
            Snack value = map.get(key);
            System.out.println("key: " + key + ", value: " + value);
        }

        System.out.println("========================");


        // 방법2. entrySet()
        Set<Map.Entry<String, Snack>> entrySet = map.entrySet();
        /*
        for(Map.Entry<String, Snack> entry : entrySet){
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
         */
        Iterator<Map.Entry<String, Snack>> itEntry = entrySet.iterator();
        while(itEntry.hasNext()){
            Map.Entry<String, Snack> entry = itEntry.next();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }
}
