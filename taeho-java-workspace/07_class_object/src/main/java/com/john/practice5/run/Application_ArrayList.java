package com.john.practice5.run;

import com.john.practice5.dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application_ArrayList {
    public static void main(String[] args) {

        List<Employee> emp = new ArrayList<>();

        emp.add(new Employee());
        emp.add(new Employee(1,"홍길동",19,'M',"01022223333","서울 잠실"));

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
        emp.get(1).setPhone("01022223333");

        System.out.println(emp.get(0).getInformation());
        System.out.println(emp.get(1).getInformation());

        System.out.println("======================================");

//        for (int i = 0; i < emp.size(); i++) {
//            int sumSalary = (int)((emp.get(i).getSalary()) + emp.get(i).getSalary()*emp.get(i).getBonusPoint()*12);
//        }

        int sum = 0;

        for (Employee employee : emp) {
            int sumSalary = (int)(employee.getSalary() + (employee.getSalary()*employee.getBonusPoint()*12));
            System.out.println(employee.getEmpName() + "의 연봉" + sumSalary);
            sum += sumSalary;
        }

        System.out.println("직원들 연봉 평균 : " + sum/ emp.size() + " 원");

    }
}
