package com.chan.mybatis_anno.controller;

import com.chan.mybatis_anno.entities.Employee;
import com.chan.mybatis_anno.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author chan
 * @create 2020-04-21 15:39
 */
@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("emp/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") Integer id) {
        Employee emp = this.employeeService.getEmpById(id);
        return emp == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(emp);
    }

    @PostMapping
    public ResponseEntity<Void> saveEmp(@RequestBody Employee employee) {
        int i = this.employeeService.saveEmp(employee);
        return i == 1 ? ResponseEntity.status(HttpStatus.CREATED).build() : ResponseEntity.badRequest().build();
    }
}
