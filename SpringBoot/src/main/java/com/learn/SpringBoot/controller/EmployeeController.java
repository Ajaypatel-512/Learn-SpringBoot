package com.learn.SpringBoot.controller;

import com.learn.SpringBoot.Entity.Employee;
import com.learn.SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//    @RequestMapping("/employees")
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.getAllEmployee();
    }

//    @RequestMapping("/employees/{id}")
    @GetMapping("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

//    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

//    @RequestMapping(value = "/employees/{id}",method = RequestMethod.PUT)
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

//    @RequestMapping(value = "/employees/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/employees/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployee();
    }

}
