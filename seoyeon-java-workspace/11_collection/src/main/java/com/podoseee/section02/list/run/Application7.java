package com.podoseee.section02.list.run;

import java.util.LinkedList;
import java.util.Queue;

public class Application7 {
    public static void main(String[] args) {
         /*
            ## java.util.Queue ##
            1. 선형 메모리 공간에 데이터를 저장하는
               선입선출(FIFO - First In First Out) 방식의 자료구조
            2. Queue는 인터페이스므로 생성 불가
               Queue를 구현하고 있는 LinkedList를 주로 사용함
         */

        Queue<String> que = new LinkedList<>();

        // * offer(E e) : 인자로 전달된 데이터 추가
        que.offer("first");
        que.offer("second");
        que.offer("third");
        que.offer("fourth");
        que.offer("fifth");

        System.out.println(que);

        // * peek() : 해당 큐의 가장 앞에 있는 요소를 반환
        System.out.println("peek(): " + que.peek());
        System.out.println("peek(): " + que.peek());

        // * poll() : 해당 큐의 가장 앞에 있는 요소를 반환하고 제거
        System.out.println("poll(): " + que.poll());
        System.out.println("poll(): " + que.poll());
    }
}
