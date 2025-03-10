package com.minkook.section04.map.run;

import com.minkook.section04.map.dto.Snack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application2 {
    public static void main(String [] args){
        Map<String, Snack> map = new HashMap<>();

        //put
        map.put("다이제",new Snack("초코맛",1500));
        map.put("칸초",new Snack("단맛",600));
        map.put("새우깡",new Snack("짠맛",500));

        map.put("포테이토칩",new Snack("짠맛",500));
        System.out.println(map);


        System.out.println("몇 세트가 담겨있는지: " + map.size());

        //replace
        map.replace("포테이토칩",new Snack("겁나짠맛",1000));
        System.out.println(map);

        //remove
        map.remove("포테이토칩");
        System.out.println(map);

        //순회해보기
        //방법1. keySet()
        Set<String> keyset = map.keySet();

        for(String key : keyset){
            System.out.println(key + " " + map.get(key));
        }
        System.out.println("================================");
        Iterator<String> it = keyset.iterator();
        while (it.hasNext()){
            String key = it.next();
            Snack value = map.get(key);
            System.out.println(key + " " + value);
        }
        System.out.println("================================");
        //방법2. entrySet()
        Set<Map.Entry<String,Snack>> entrySet = map.entrySet();

        for(Map.Entry<String,Snack> entry : entrySet){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("================================");
        Iterator<Map.Entry<String,Snack>> itEntry = entrySet.iterator();

        while(itEntry.hasNext()){
            Map.Entry<String,Snack> key = itEntry.next();
            System.out.println(key.getKey() + " " + key.getValue());

        }
    }


}
