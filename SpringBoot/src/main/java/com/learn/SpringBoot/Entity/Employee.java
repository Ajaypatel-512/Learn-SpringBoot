package com.learn.SpringBoot.Entity;

public class Employee {

    private int id;
    private String EmpName;
    private String City;

    public Employee(int id, String empName, String city) {
        this.id = id;
        EmpName = empName;
        City = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
