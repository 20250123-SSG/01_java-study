package section04.map.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        /**
         * ## Map 컬렉션
         * 1. Collection인터페이스와 다른 저장 방식
         * 2. key-value 쌍으로 저장
         *      - key : 값을 식별해주는 식별자의 역할 (set으로 관리, 순서x,중복x)
         *      - value : 데이터, 중복허용
         *      - Entry  = key + value
         *
         */

        /// 해시알고리즘은 사용하여 검색 속도가 매우 빠름
        HashMap<String, Object> stu = new HashMap<>();
        stu.put("name", "홍길동");
        stu.put("age", 18);
        stu.put("height", 140.3);
        stu.put("kor", 100);
        stu.put("eng", 90);
        stu.put("kor", 12);

        System.out.println(stu);


        Object name = stu.get("name");
        int afe = (int) stu.get("age");
        System.out.println(name);

        Map<String, Object> stu2 = Map.of("name", "이서연"
                , "age", 10000
                , "height", -999999
                , "kor", -23);


        for (Map.Entry<String, Object> entry : stu2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Set<String> keySet = stu2.keySet();
        Set<Map.Entry<String, Object>> entries = stu2.entrySet();

        Iterator<String> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            Object value = stu2.get(key);
            System.out.println(key + value);
        }
    }

}
