package com.inyong.section04.run;

import com.inyong.section04.map.dto.Snack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {
        Map<String, Snack> map = new HashMap<>();

        map.put("다이제", new Snack("초코맛", 1500));
        map.put("칸초", new Snack("단", 600));
        map.put("새우깡", new Snack("짠", 500));
        map.put("포테이토", new Snack("짠", 500));

        System.out.println(map);
        // get, replace, remove

        Snack s = map.get("다이제");
        System.out.println(s);
        System.out.println(map.size());

        map.replace("포테이토칩", new Snack("겁나 짠맛", 1000));
        System.out.println(map);

        // 순회
        // 1. keySet()
        Set<String> keySet = map.keySet();
        Iterator<String> itKey = keySet.iterator();
        while (itKey.hasNext()) {
            String key = itKey.next();
            Snack value = map.get(key);
            System.out.println(key + " " + value);
        }

        // 2, entrySet()
        Set<Map.Entry<String, Snack>> enrtySet = map.entrySet();

        Iterator<Map.Entry<String, Snack>> itEntry = enrtySet.iterator();
        while (itEntry.hasNext()) {
            Map.Entry<String, Snack> entry = itEntry.next();
            System.out.println(entry.getKey() + entry.getValue());
        }

    }
}

