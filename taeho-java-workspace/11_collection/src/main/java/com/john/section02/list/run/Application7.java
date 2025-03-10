package com.john.section02.list.run;

import java.util.LinkedList;
import java.util.Queue;

/*
    Queue
    - 선형 메모리 공간에 데이터를 저장하는 선입 선출(FIFO First In First Out) 방식의 자료구조
    - Queue는 인터페이스이므로 생성불가 // Queue를 구현하고 있는 LinkedList를 주로 사용함
 */
public class Application7 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        queue.offer("Hello");
        queue.offer("World");
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);

    }
}
