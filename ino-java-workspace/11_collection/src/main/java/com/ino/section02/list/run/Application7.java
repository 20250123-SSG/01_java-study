package com.ino.section02.list.run;

import java.util.PriorityQueue;

public class Application7 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(1, (o1, o2) -> o2 - o1);
        pq.add(2);
        pq.add(20);
        pq.add(200);
        pq.add(2000);
        pq.add(20000);
        pq.add(200000);
        pq.add(2000000);
        System.out.println(pq.poll());
    }
}
