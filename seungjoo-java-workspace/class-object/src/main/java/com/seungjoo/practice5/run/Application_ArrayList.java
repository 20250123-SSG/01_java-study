package com.seungjoo.practice5.run;

import com.seungjoo.practice5.dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application_ArrayList {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "홍길동", 19, 'M', "01022223333", "서울 잠실"));
        emp.add(new Employee(2,"강말순", "교육부", "강사", 20, 'F',1000000, 0.01, "01011112222", "서울 마곡"));
    }
    }


