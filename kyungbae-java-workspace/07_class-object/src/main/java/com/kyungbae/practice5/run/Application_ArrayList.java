package com.kyungbae.practice5.run;

import com.kyungbae.practice5.dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application_ArrayList {
    public static void main(String[] args) {

        List<Employee> emp = new ArrayList<>();

        emp.add(new Employee());
        emp.add(new Employee(1, "홍길동", 19, 'M', "01022223333", "서울 마곡"));
        emp.add(new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡"));

        for (int i = 0; i < emp.size(); i++) {
            System.out.println("emp[" + i + "] : " + emp.get(i));
        }

        System.out.println("========================================");

        emp.get(0).setEmpName("김말똥");
        emp.get(0).setDept("영업부");
        emp.get(0).setJob("팀장");
        emp.get(0).setAge(30);
        emp.get(0).setGender('M');
        emp.get(0).setSalary(3000000);
        emp.get(0).setBonusPoint(0.2);
        emp.get(0).setPhone("01055559999");
        emp.get(0).setAddress("전라도 광주");

        emp.get(1).setDept("기획부");
        emp.get(1).setJob("부장");
        emp.get(1).setSalary(4000000);
        emp.get(1).setBonusPoint(0.3);

        System.out.println("emp.get(0)= " + emp.get(0));
        System.out.println("emp.get(1)= " + emp.get(1));

        System.out.println("========================================");

        int sum = 0;
        for (Employee e : emp) {
            int sumSalary = (int)(e.getSalary() + (e.getBonusPoint() * e.getSalary())) * 12;
            System.out.println(e.getEmpName() + "의 연봉 : " + sumSalary);
            sum += sumSalary;
        }

        System.out.println("직원들의 연봉의 평균 : " + sum / emp.size() + "원");

    }
}
