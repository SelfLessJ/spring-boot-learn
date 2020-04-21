package com.chan.mybatis_xml.service.impl;

import com.chan.mybatis_xml.entities.Employee;
import com.chan.mybatis_xml.mapper.EmployeeMapper;
import com.chan.mybatis_xml.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chan
 * @create 2020-04-21 15:33
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmpById(Integer id) {
        return this.employeeMapper.getEmpById(id);
    }

    @Override
    public int saveEmp(Employee emp) {
        return this.employeeMapper.saveEmp(emp);
    }
}
