package com.kyungbae.section03.set.run;

import com.kyungbae.section03.set.dto.Student;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {

        Set<String> stringSet = new TreeSet<>();

        stringSet.add("hahaha");
        stringSet.add("nanana");
        stringSet.add("dadada");
        stringSet.add("kakaka");
        stringSet.add("hahaha");

        System.out.println(stringSet); // 순서유지x, 중복허용x

        Set<Student> stuSet = new TreeSet<>();

        // TreeSet에 저장가능한 요소는 Comparable이 구현되어있는 클래스야만 한다
        stuSet.add(new Student("공유", 43, 100));
        stuSet.add(new Student("홍길동", 24, 40));
        stuSet.add(new Student("김말동", 26, 20));

        System.out.println(stuSet);

    }
}
