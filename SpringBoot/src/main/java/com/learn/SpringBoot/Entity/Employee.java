package com.learn.SpringBoot.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String EmpName;
    private String City;

    public Employee() {
    }

    public Employee(int id, String empName, String city) {
        this.id = id;
        this.EmpName = empName;
        this.City = city;
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
        this.EmpName = empName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }
}
