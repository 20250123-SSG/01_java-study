package com.kyungbae.practice4.controller;

import com.kyungbae.practice4.dto.Employee;

public class EmployeeManager {
    Employee emp = new Employee();
    public Boolean inputEmployee (String name, String dept, String job, String age, String gender, String salary, String bonusPoint, String phone, String address){
        emp = new Employee(name, dept, job, age, gender, salary, bonusPoint, phone, address);
        return true;
    }

    public boolean modifyName(String name){
        emp.setEmpName(name);
        return true;
    }

    public boolean modifySalary (String salary){
        emp.setSalary(salary);
        return true;
    }

    public boolean modifyDept (String dept){
        emp.setDept(dept);
        return true;
    }

    public boolean modifyJob(String job){
        emp.setJob(job);
        return true;
    }

    public boolean deleteEmployee(){
        emp.setEmpName(null);
        emp.setDept(null);
        emp.setJob(null);
        emp.setAge(null);
        emp.setGender(null);
        emp.setSalary(null);
        emp.setBonusPoint(null);
        emp.setPhone(null);
        emp.setAddress(null);
        return true;
    }

    public String outputEmployee(){
        return emp.toString();
    }


}
