package com.seungjoo.section03.set.run;

import com.seungjoo.section03.set.dto.Student;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {

        Set<String> stringset = new TreeSet<String>();

        Set<Student> stuSet = new TreeSet<>();
        stuSet.add(new Student("공유", 43,100));
        stuSet.add(new Student("홍길동", 43,100));
        stuSet.add(new Student("김말똥", 43,100));

    }
}
