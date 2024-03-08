package com.learn.SpringBoot.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String empName;
    private String empCity;

//    @OneToOne(cascade = CascadeType.ALL) // cascading All
//    @OneToOne(cascade = CascadeType.PERSIST) // cascading Persist
//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}) // cascading Persist
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY) // fetch lazy
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;

//    @OneToMany(cascade = CascadeType.ALL)
//    @OneToMany(cascade = CascadeType.PERSIST)
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Address> addresses;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @ManyToMany(cascade = CascadeType.PERSIST)
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "fk_employee"),
    inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private Set<Project> projects = new HashSet<>();

    public Employee() {
    }

    public Employee(int id, String empName, String city) {
        this.employeeId = id;
        this.empName = empName;
        this.empCity = city;
    }

    public Employee(String employee1, String city1) {
        empName = employee1;
        empCity = city1;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
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

    public void addAddress(Address address){
        this.addresses = new ArrayList<>();
        this.addresses.add(address);
        address.setEmployee(this);
    }

    public void removeAddress(Address address){
        this.addresses.remove(address);
        address.setEmployee(null);
    }


}
