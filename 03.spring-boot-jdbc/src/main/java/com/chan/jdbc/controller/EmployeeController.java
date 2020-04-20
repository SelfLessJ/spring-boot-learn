package com.chan.jdbc.controller;

import com.chan.jdbc.entities.Employee;
import com.chan.jdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chan
 * @create 2020-04-20 22:22
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeService.getEmpById(id);
    }

    @GetMapping("emps")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
}
