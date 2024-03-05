package com.learn.SpringBoot.service;


import com.learn.SpringBoot.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "First Employee", "Washington"),
            new Employee(2, "Second Employee", "New York")
    ));

    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    public Employee getEmployeeById(int id){
        return employeeList.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public void createEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void updateEmployee(Employee employee){
        List<Employee> temp = new ArrayList<>();
        for (Employee emp : employeeList){
            if (emp.getId() == employee.getId()){
                emp.setEmpName(employee.getEmpName());
                emp.setCity(employee.getCity());
            }
            temp.add(emp);
        }
        this.employeeList = temp;
    }

    public void deleteEmployee(int id){
        List<Employee> temp = new ArrayList<>();
        for (Employee emp : employeeList){
            if (emp.getId() == id){
                continue;
            }
            temp.add(emp);
        }
        this.employeeList = temp;
    }
}
