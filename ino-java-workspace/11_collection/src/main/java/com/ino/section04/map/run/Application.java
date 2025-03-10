package com.ino.section04.map.run;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        HashMap<Object, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("name", "gildong");
        stringObjectMap.put("age", 10);
        stringObjectMap.put("height", 140.3);
        Set<Object> keySet = stringObjectMap.keySet();
        List keyList = new LinkedList(keySet);
        Collections.sort(keyList, (o1, o2) -> ((String) o2).length() - ((String) o1).length());

        keyList.sort((o1, o2) -> ((String)o2).length() - ((String)o1).length());
        Iterator itk = keySet.iterator();
        while (itk.hasNext()) {
            String key = (String) itk.next();
            System.out.println(key);
        }
        Set<Map.Entry<Object, Object>> entries = stringObjectMap.entrySet();
        Iterator<Map.Entry<Object, Object>> itEntry = entries.iterator();
        while (itEntry.hasNext()) {
            Map.Entry<Object, Object> entry = itEntry.next();
            Object Key = entry.getKey();
            Object Value = entry.getKey();
        }
    }
}
