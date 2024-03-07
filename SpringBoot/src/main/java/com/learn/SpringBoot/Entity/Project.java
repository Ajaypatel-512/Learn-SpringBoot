package com.learn.SpringBoot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String clientName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employeeList;

    public Project(String name, String clientName) {
        this.name = name;
        this.clientName = clientName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClientName() {
        return clientName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
