package com.inyong.section03.set.run;

import com.inyong.section03.set.dto.Student;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        Set<String> stringSet = new TreeSet<>();

        stringSet.add("가가가");
        stringSet.add("나나나");
        stringSet.add("다다다");
        stringSet.add("가가가");

        System.out.println(stringSet); // 순서유지 x, 중복 허용 x

        /*
        java util TreeSet
        이진검색트리의 형태로 관리
        데이터를 추가하거나 제거할때 기본 동작 시간이 매우 빠름
        1.2 부터
        Set 인터페이스가 가지는 특징을 그대로 가지지만 정렬된 상태로 데이터를 유지한다는게 다름
         */

        Set<Student> stuSet = new TreeSet<>();
        stuSet.add(new Student("공", 43, 100));
        stuSet.add(new Student("홍", 46, 40));
        stuSet.add(new Student("김", 44, 50));

        System.out.println(stuSet);

    }
}
