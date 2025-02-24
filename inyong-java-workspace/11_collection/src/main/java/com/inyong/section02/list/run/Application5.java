package com.inyong.section02.list.run;

import java.util.LinkedList;

public class Application5 {
    public static void main(String[] args) {
        /*
        java.uti.LinkedList
        1. 이중 연결 리스트 잘구조의 컬렉션
        2. 데이터와 데이터를 체인처럼 연결시켜 관리하는 구조
        3. 요소들 간에 앞 뒤에 Noode라는 걸로 연결되어 있어 특정 위치의 요소를 추가하거나
        삭제할 때 배열로 관리되는 ArrayList 같은 경우 기존의 요소들을 옮겨주는 작업이 내부적으로 진행됨
        LinkedList는 해당 요소의 앞 뒤 링크만 연결하면됨
        4. 삭제나 삽입이 빈번할 경우 LinkedList가 좋은 성능을 냄

         */

        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add(1, "f");

        System.out.println(list);


        //* size()
        //* get(int index) ->  반복문 사용 가능

        list.addFirst("홍길동");
        list.addLast("asdf");

        System.out.println(list);

        list.remove(1);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);

    }
}
