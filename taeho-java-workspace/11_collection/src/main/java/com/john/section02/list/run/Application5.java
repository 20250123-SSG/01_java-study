package com.john.section02.list.run;


import java.util.LinkedList;

/*
    LinkedList
    1. 이중 연결리스트 자료구조 컬렉션
    2. 각 데이터를 체인처럼 연결시켜 관리(노드)
        => 특정 위치의 요소를 추가/삭제할 때 편리
            // ArrayList의 경우 추가하고자 하는 인덱스를 비우기 위해 인덱스 이후의 모든 값들을
            하나씩 인덱스를 증가시켜 비우는 형태
            // LinkedList의 경우 추가/삭제 하고자 하는 인덱스의 앞 뒤 값 사이에 요소를 추가/삭제

 */
public class Application5 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add(1,"ㄱ");

        System.out.println(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        // addFirst(E e): 첫번째 위치에 전달한 요소를 추가
        list.addFirst("Wow I'm addFirst");
        System.out.println(list);

        list.addLast("Wow I'm addLast");
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}
