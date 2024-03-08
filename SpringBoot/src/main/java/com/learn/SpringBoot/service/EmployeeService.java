package com.learn.SpringBoot.service;


import com.learn.SpringBoot.Entity.Address;
import com.learn.SpringBoot.Entity.Employee;
import com.learn.SpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "First Employee", "Washington"),
            new Employee(2, "Second Employee", "New York")
    ));

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
//        return employeeList.stream().filter(e -> e.getId() == id).findFirst().get();
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found"));
    }

    public void createEmployee(Employee employee){
//        employeeList.add(employee);
        ArrayList<Address> addressArrayList = new ArrayList<>();
        for (Address address: employee.getAddresses()){
            addressArrayList.add(new Address(address.getLine1(),
                    address.getLine2(),
                    address.getZipCode(),
                    address.getCity(),
                    address.getState(),
                    address.getCountry(),
                    employee));
        }
        employee.setAddresses(addressArrayList);
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
//        List<Employee> temp = new ArrayList<>();
//        for (Employee emp : employeeList){
//            if (emp.getId() == employee.getId()){
//                emp.setEmpName(employee.getEmpName());
//                emp.setCity(employee.getCity());
//            }
//            temp.add(emp);
//        }
//        this.employeeList = temp;

        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id){
//        List<Employee> temp = new ArrayList<>();
//        for (Employee emp : employeeList){
//            if (emp.getId() == id){
//                continue;
//            }
//            temp.add(emp);
//        }
//        this.employeeList = temp;

        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
}
