package com.inyong.section03.set.run;

import com.inyong.section03.set.dto.Student;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();

        System.out.println("초기 set : " + set);

        set.add(new Student("김말똥", 26, 40));
        set.add(new Student("공윺", 46, 20));
        set.add(new Student("김소똥", 26, 30));
        set.add(new Student("김닭똥", 46, 50));
        /*
        add 메소드 내에서 기존에 존재하는 요소들과 인자로 전달된 요소가지고 동등객체인지 판별
        => hashCode() 의 결과가 일치하고 equals() 결과가 true일 경우 동등객체로 판별

        Student 클래스에 hashCode, equals 오버라이딩전 : Object 클래스의 HashCode, equals가 수행됨
        => 주소값으로 비교

        Student 클래스에 hashCode, equals 오버라이딩후 : Student 클래스의 HashCode, equals가 수행됨
        => 필드값으로 비교

        */
        System.out.println("추가후 set: " + set); // 순서 유지X

        // * contains(Object o) : Set 내에 전달된 요소가 포함되어있을 경우 true 반환

        System.out.println(set.contains(new Student("홍길동", 24, 20)));

        // 향상된 포문
        for(Student student : set){
            System.out.println(student);
        }

        // 배열 치환
        Object[] stuArr;

        // List 치환
        List<Student> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Iterator
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
