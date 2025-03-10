package section03.set.run;

import section03.set.dto.Student;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("A");

        System.out.println(set);

        /**
         * ## TreeSet - 순서가 유지되는
         * 1. 데이터가 정렬된 상태로 저장되는 이진검색트리의 형태로 관리
         * 2. LinkedList와 동이하게 값을 추가하거나 삭제하는 시간이 매우 빠름
         * 3. 순회는 느림
         * 4. Set인터페이스가 갖는 특성은 같지만 정렬된 상태로 데이터 유지
         */

        Set<Student> stuSet = new TreeSet<>();
        stuSet.add(new Student("공유", 12, 143));
        stuSet.add(new Student("홍길동", 2, 10));
        stuSet.add(new Student("김말동", 24, 0));

    }
}
