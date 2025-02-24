package section02.list.run;

import java.util.LinkedList;

public class Application5 {
    public static void main(String[] args) {
        /**
         * ## LinkedList
         * 1. 이중 연결 자료구조의 컬렉션
         * 2. 데이터와 데이터를 퐁당퐁당 연결되어 관리 0-0-0-0-0-0
         * 3. 요소들간에 Node가 연결되어있어 중간 위치에 추가 삭제가 용이함
         *      단, 조회 속도가 느림
         */

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(0,"d");

        /// set, get 등등 기본적인 기능은 List와 똑같음

        /// addFirst 첫번째 위치에 전달한 요소를 추가
        list.addFirst("첫");
        list.addLast("마지막");

        list.removeFirst();
        list.removeLast();

    }
}
