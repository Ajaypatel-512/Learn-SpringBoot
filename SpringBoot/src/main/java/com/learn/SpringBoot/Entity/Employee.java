package com.learn.SpringBoot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String EmpName;
    private String City;

    @OneToOne
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;

    @OneToMany
    private List<Address> addresses;

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
}
