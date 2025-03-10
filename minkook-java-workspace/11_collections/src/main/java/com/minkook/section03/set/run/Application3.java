package com.minkook.section03.set.run;

import com.minkook.section03.set.dto.Student;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String [] args){

        Set<String> stringSet = new TreeSet<>();

        stringSet.add("하하하");
        stringSet.add("나나나");
        stringSet.add("가가가");
        stringSet.add("다다다");
        stringSet.add("하하하");

        System.out.println(stringSet); //순서유지 x 중복허용x
        
        /*
            ## java.util.TreeSet ##
            1. 데이터가 정렬된 상태로 저장되는 이진검색트리의 형태로 관리
            2. 이진검색트리는 데이터를 추가하거나 제거할때 기본 동작 시간이 매우빠름
            3. jdk 1.2부터 제공
            4. Set 인터페이스가 가지는 특징으 그대로 가지지만 정렬된 상태로 데이터를 유지하는게 다름
         */

        Set<Student> students = new TreeSet<>();
        //TreeSet에 저장가능한 요소는 Comparable이 구현되어있는 클래스
        students.add(new Student("공유",43,100));
        students.add(new Student("홍길동",24,40));
        students.add(new Student("김말똥",26,30));

        System.out.println(students);
    }
}
