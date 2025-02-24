package com.kyungbae.section02.list.run;

import java.util.LinkedList;

public class Application5 {
    public static void main(String[] args) {
        // Linked List
        LinkedList<String> list = new LinkedList<>();

        // add(E e)
        list.add("캥거루");
        list.add("김말똥");
        list.add("강개순");
        // add(int index, E e)
        list.add(1, "홍길순");

        System.out.println(list);

        // size()
        // get(int index)
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // addFirst(E e) : 첫번째 위치에 전달한 요소를 추가
        list.addFirst("홍길동");
        System.out.println(list);

        //addLast(E e) : 마지막 위치에 전달한 요소를 추가
        list.addLast("강길동");
        System.out.println(list);

        // getFirst() / getLast() : 첫번째 마지막 위치에서 요소를 반환
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        // remove(int index)
        list.remove(1);
        System.out.println(list);

        // removeFirst() / removeLast()
        list.removeFirst();
        list.removeLast();

    }
}
