package com.ino.section04.map.run;

import com.ino.section04.map.dto.Snack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {
        Map<String, Snack> snackMap = new HashMap<>();
        snackMap.put("potato chip", new Snack("salty", 2000));
        snackMap.put("poca chip", new Snack("very salty", 1500));
        snackMap.put("swing chip", new Snack("too salty", 2300));
        snackMap.put("chip", new Snack("so salty", 2700));

        Iterator<Map.Entry<String, Snack>> itEntry = snackMap.entrySet().iterator();
        while(itEntry.hasNext()) {
            Map.Entry<String, Snack> node = itEntry.next();
            String key = node.getKey();
            Snack value = node.getValue();
        }
    }
}
