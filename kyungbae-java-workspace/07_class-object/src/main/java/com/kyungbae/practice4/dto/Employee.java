package com.kyungbae.practice4.dto;

public class Employee {

    private String empName;
    private String dept;
    private String job;
    private String age;
    private String gender;
    private String salary;
    private String bonusPoint;
    private String phone;
    private String address;

    public Employee(){}

    public Employee(String empName, String dept, String job, String age, String gender, String salary, String bonusPoint, String phone, String address) {
        this.empName = empName;
        this.dept = dept;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.bonusPoint = bonusPoint;
        this.phone = phone;
        this.address = address;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(String bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", dept='" + dept + '\'' +
                ", job='" + job + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", salary='" + salary + '\'' +
                ", bonusPoint='" + bonusPoint + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
