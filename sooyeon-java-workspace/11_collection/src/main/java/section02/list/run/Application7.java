package section02.list.run;

import java.util.LinkedList;
import java.util.Queue;

public class Application7 {
    public static void main(String[] args) {
        /**
         * ## Queue
         * 1. 선형 메모리 공간에 데이터를 저장
         *      선입선출 FIFO - First Input First Out
         * 2. 인터페이스로 생성 불가
         *      큐를 구현하고있는 LinkedList를 주로 사용
         *
         *
         * ㅁ    ㅁ
         * ㅁ -> ㅁ +
         * ㅁ          ㅁ
         */

        Queue<String> que = new LinkedList<>();

        que.offer("a");
        que.offer("b");
        que.offer("c");
        que.offer("d");
        que.offer("e");

        System.out.println(que);

        System.out.println(que.peek());
        que.poll();
        System.out.println(que.peek());

        String b = que.poll();
        System.out.println(b);
        System.out.println(que);

    }
}
