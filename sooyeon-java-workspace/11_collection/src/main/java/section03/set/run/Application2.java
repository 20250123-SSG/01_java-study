package section03.set.run;

import section03.set.dto.Student;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();

        set.add(new Student("김말똥", 26, 40));
        set.add(new Student("공유", 43, 100));
        set.add(new Student("홍길동", 24, 20));
        set.add(new Student("공유", 43, 100));

        System.out.println(set);

        System.out.println(set.contains(new Student("홍길동", 24, 20))); //t

        for (Student student : set) {
            System.out.println(student);
        }

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<Student> list = new ArrayList<>(set);
        for(int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

        for(Student student : List.copyOf(set)){
            System.out.println(student);
        }

        for(Object student : set.toArray()){
            System.out.println(student);
        }

    }
}
