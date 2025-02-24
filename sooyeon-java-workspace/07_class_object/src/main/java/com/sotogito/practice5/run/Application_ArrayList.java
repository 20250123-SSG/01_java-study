package com.sotogito.practice5.run;

import com.sotogito.practice5.dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application_ArrayList {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee());
        employees.add(new Employee(1, "홍길동", 19, 'M', "01022223333", " 서울 잠실"));
        employees.add(new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡"));

        for (Employee employee : employees) {
            System.out.println(employee.getInformation());
        }

        Employee em1 = employees.get(0);
        em1.setEmpNo(0);
        em1.setEmpName("김말똥");
        em1.setDept("영업부");
        em1.setJob("팀장");
        em1.setAge(30);
        em1.setGender('M');
        em1.setSalary(3000000);
        em1.setBonusPoint(0.2);
        em1.setPhone("01055559999");
        em1.setAddress("전라도 광주");

        Employee em2 = employees.get(1);
        em2.setDept("기획부");
        em2.setJob("부장");
        em2.setSalary(4000000);
        em2.setBonusPoint(0.3);

        System.out.println(em1);
        System.out.println(em2);

        int totalSalary = 0;
        for(Employee employee : employees) {
            int salary = (int)( 12*((employee.getSalary())+ (employee.getSalary()* employee.getBonusPoint())));
            totalSalary += salary;
            System.out.printf("%s의 연봉 : %d원\n",employee.getEmpName(),salary);
        }

        System.out.println(totalSalary);

    }
}
