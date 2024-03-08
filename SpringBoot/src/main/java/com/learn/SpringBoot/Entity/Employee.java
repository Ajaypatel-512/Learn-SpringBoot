package com.learn.SpringBoot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String empName;
    private String empCity;

//    @OneToOne(cascade = CascadeType.ALL) // cascading All
    @OneToOne(cascade = CascadeType.PERSIST) // cascading Persist
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;

//    @OneToMany(cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses;

//    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "fk_employee"),
    inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private List<Project> projects;

    public Employee() {
    }

    public Employee(int id, String empName, String city) {
        this.employeeId = id;
        this.empName = empName;
        this.empCity = city;
    }

    public int getId() {
        return employeeId;
    }

    public void setId(int id) {
        this.employeeId = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project){
        this.projects.remove(project);
        project.getEmployeeList().remove(project);
    }

    public void addProject(Project project){
        this.projects.add(project);
        project.getEmployeeList().add(this);
    }



}
