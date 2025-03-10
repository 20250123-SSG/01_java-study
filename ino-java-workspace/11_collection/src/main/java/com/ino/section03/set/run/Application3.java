package com.ino.section03.set.run;

import com.ino.section03.set.dto.Student;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        Set<Student> stuSet = new TreeSet<>();
        stuSet.add(new Student("a", 20, 30));
        stuSet.add(new Student("b", 20, 50));
        stuSet.add(new Student("c", 20, 60));
        stuSet.add(new Student("d", 20, 70));
    }
}
