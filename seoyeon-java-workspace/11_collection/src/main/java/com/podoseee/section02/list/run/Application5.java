package com.podoseee.section02.list.run;

import java.util.LinkedList;

public class Application5 {
    public static void main(String[] args) {
        /*
            ## java.util.LinkedList ##
            1. 이중 연결 리스트 자료구조의 컬렉션
            2. 데이터와 데이터를 체인처럼 연결시켜 관리하는 구조
            3. 요소들 간에 앞 뒤에 Node라는 걸로 연결되어 있어 특정 위치의 요소를 추가하거나 삭제할 때
               배열로 관리되는 ArrayList 같은 경우 기존의 요소들을 옮겨주는 작업이 내부적으로 진행됨
               LinkedList는 해당 요소의 앞 뒤만 링크만 연결하면됨
            4. 삭제나 삽입이 빈번할 경우 LinkedList가 좋은 성능을 냄
         */
        LinkedList<String> list = new LinkedList<>();

        // * add(E e)
        list.add("포도씨");
        list.add("수박씨");
        list.add("복숭아씨");
        // * add(int index, E e)
        list.add(1, "사과씨");

        System.out.println(list);

        // * size()
        // * get(int index)
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        // * addFirst(E e) : 첫 번째 위치에 전달한 요소를 추가
        list.addFirst("배씨");
        System.out.println(list);

        // * addLast(E e) : 마지막 위치에 전달한 요소를 추가
        list.addLast("키위씨");
        System.out.println(list);

        // * getFirst() / getLast() : 첫 번째 또는 마지막 위치의 요소를 반환
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        // * remove(int index)
        list.remove(1);
        System.out.println(list);

        // * removeFirst() / removeLast()
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}
