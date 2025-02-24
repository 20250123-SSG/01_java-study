package com.ino.practice5.run;

import com.ino.practice5.dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application_ArrayList {
    public static void main(String[] args) {
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee());
        employee.add(new Employee(1, "123", 3, 'A', "asddf", "asfasf"));
        employee.add(new Employee(1, "123", "1234", "123124", 3, 'A', 123124, 1532.0, "asfasf", "123124"));
        employee.get(0).setEmpNo(2);
        employee.get(0).setEmpName("12412");
        employee.get(0).setAge(2);
        employee.get(0).setGender('e');
        employee.get(0).setPhone("123124");
        employee.get(0).setAddress("124124124");
        employee.get(0).setDept("1234214");
        employee.get(0).setJob("hi");
        employee.get(0).setSalary(124211241);
        employee.get(0).setBonusPoint(12421124);
        employee.get(1).setDept("1234214");
        employee.get(1).setJob("hi");
        employee.get(1).setSalary(124211241);
        employee.get(1).setBonusPoint(12421124);
        int sum = 0;
        for(Employee e : employee) {
            int sumSal = (int)(e.getSalary() + (e.getSalary() * e.getBonusPoint()));
            System.out.println(e.getEmpName() + " 연봉 " + sumSal);
            sum += sumSal;
        }
    }
}
