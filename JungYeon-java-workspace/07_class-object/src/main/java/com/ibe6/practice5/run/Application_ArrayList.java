package com.ibe6.practice5.run;

import com.ibe6.practice5.dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application_ArrayList {
    public static void main(String[] args) {

        List<Employee> emp = new ArrayList<>();

        emp.add(new Employee());
        emp.add(new Employee(1, "홍길동", 19, 'M', "01022223333", "서울잠실"));
        emp.add(new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000
                            ,0.01, "01011112222", "서울 마곡"));

        for(int i=0; i<emp.size(); i++){
            System.out.println("emp[" + i + "]");
        }

        System.out.println("===");

        emp[0].setEmpNo(0);
        emp[0].setEmpName("김말똥");
        emp[0].setEmp("영업부??");

        emp.get(1).setDept("기획부");
        emp.get(1).setJob("부장");
        emp.get(1).setSalary(4000000);
        emp.get(1).setBonusPoint(0.3);

        int sum = 0;
        /*
        for(int i=0; i<emp.size(); i++){
            int sumSalary = (int)(emp.get(i).getSalary() + (emp.get(i).getSalary() * emp.get(i).getBonusPoint()));
            */
        for(Employee e : emp){
            int sumSalary = (int)(e.getSalary() + (e.getSalary() * e.getBonusPoint())) * 12;
            System.out.println(e.getEmpName() + "의 연봉: " + sumSalary);
            sum += sumSalary;

        }

        System.out.println("직원들의 연봉 평균: " + sum / emp.size() + "원");



    }
}
