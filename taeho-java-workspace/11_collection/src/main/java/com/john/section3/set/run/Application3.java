package com.john.section3.set.run;

import com.john.section3.set.dto.Student;

import java.util.Set;
import java.util.TreeSet;

/*
    TreeSet // 순서유지X , 중복허용X
    - 데이터가 정렬된 상태로 저장되는 이진검색트리의 형태로 관리
 */
public class Application3 {
    public static void main(String[] args) {
        Set<String> stringSet = new TreeSet<>();
        stringSet.add("A");
        stringSet.add("B");
        stringSet.add("C");
        stringSet.add("김가나");
        stringSet.add("하이톤");
        stringSet.add("바리톤");
        stringSet.add("C");

        System.out.println(stringSet);

        Set<Student> studentSet = new TreeSet<>();

        //TreeSet에 저장 가능한 요소는 Comparable 이 구현되어있는 클래스
        studentSet.add(new Student("켄트벡",26,42));
        studentSet.add(new Student("김캐리",25,36));
        studentSet.add(new Student("마이너",39,99));
        System.out.println(studentSet);

    }
}
