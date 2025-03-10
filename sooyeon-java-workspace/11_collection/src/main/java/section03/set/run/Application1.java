package section03.set.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        /**
         * ## Set 컬렉션
         * 순서x, 중복x
         * 1. 집합의 형태로 데이터 관리
         * 2. 순서를 유지하지 않음 - index의 개념 없음
         * 3. 중복된 요소 허용 x
         *
         * ## HashSet
         * 1. 해시 알고리즘을 사용하여 내부적으로 검색 속도가 빠름
         * 2. 중복 요소 판별시, hashCode -> equals 순으로 동등 비교 수행
         */

        Set set = new HashSet();

        set.add("안녀아");
        set.add(10);
        set.add(20.4);
        set.add(10);

        System.out.println(set);


        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(1);

        System.out.println(integerSet);
        System.out.println(integerSet.size());


        Set<Integer> lotto = new HashSet<>();
        int count = 0;
        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45 + 1));
            count++;
        }
        System.out.println(lotto);
        System.out.println(count);

        Set<String> stringSet = Set.of("java","mysql","jdbc","mybatis","spring"); //불변

        for(String string : stringSet) {
            System.out.println(string);
        }

        Object[] array = stringSet.toArray();//기본 toArray자료형은 Object


        /**
         * Set -> List 변환
         */
        /// 리스트 바로 생성
        List<String> list = new ArrayList<>(stringSet);

        /// 리스트 생성 + addAll
        List<String> list1 = new ArrayList<>();
        list.addAll(list);


        /// 반복자 Iterator
        /**
         * 1. 컬렉션 순회 용이
         * 2. 단방향, 일회성
         */
        Iterator<String> iterator = stringSet.iterator();

    }
}
