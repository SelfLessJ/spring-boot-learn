package com.chan.mybatis_druid.service;


import com.chan.mybatis_druid.entities.Employee;

/**
 * @author chan
 * @create 2020-04-21 15:31
 */
public interface IEmployeeService {

    /**
     * 查询指定员工信息
     *
     * @param id
     * @return
     */
    Employee getEmpById(Integer id);

    /**
     * 新增员工
     *
     * @param emp
     * @return
     */
    int saveEmp(Employee emp);
}
