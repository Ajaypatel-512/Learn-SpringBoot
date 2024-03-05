package com.learn.SpringBoot.repository;

import com.learn.SpringBoot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    /**
     * CRUD
     *
     * getAllEmployees()
     * getEmployee(id)
     * updateEmployee(Employee employee)
     * deleteEmployee(Employee employee)
     *
     * */



}
