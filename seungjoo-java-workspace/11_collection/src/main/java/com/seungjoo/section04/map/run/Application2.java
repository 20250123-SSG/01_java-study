package com.seungjoo.section04.map.run;

import com.seungjoo.section04.map.dto.Snack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {

        Map<String, Snack> map  = new HashMap<>();

        map.put("다이제", new Snack("초코맛", 1500));
        map.put("칸초", new Snack("단맛", 600));
        map.put("새우깡", new Snack("짠맛", 500));
        map.put("포테이토칩", new Snack("짠맛", 500));

        System.out.println(map);

        map.put("새우깡", new Snack("매운맛", 700));
        System.out.println(map);

        Snack s = map.get("다이제");

        System.out.println("몇 세트가 담겨있는지: " + map.size());

        map.replace("포테이토칩", new Snack("겁나 짠맛", 1000));
        System.out.println(map);


    Set<String> keys = map.keySet();
    for(String key : keys){
        System.out.println(map.get(key));
    }
    Set<Map.Entry<String,Snack>> entrySet = map.entrySet();
    Iterator<Map.Entry<String, Snack>> iterator = entrySet.iterator();
    while(iterator.hasNext()){
        Map.Entry<String, Snack> entry = iterator.next();
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
    }
        for (Map.Entry<String, Snack> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }





    }
}
