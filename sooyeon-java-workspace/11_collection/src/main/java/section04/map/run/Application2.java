package section04.map.run;

import section04.map.dto.Snack;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Application2 {
    public static void main(String[] args) {
        Map<String, Snack> map = new TreeMap<String, Snack>();
        map.put("다이제", new Snack("초코", 1500));
        map.put("칸쵸", new Snack("단맛", 600));
        map.put("새우깡", new Snack("짠맛", 500));
        map.put("포테이토칩", new Snack("짠맛", 500)); //value는 중복되어도 들어감

        System.out.println(map);

        System.out.println(map.size());
        map.replace("포테이토칩", new Snack("짠ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ맛", 1000));

        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        for (Map.Entry<String, Snack> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Iterator<Map.Entry<String, Snack>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Snack> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
