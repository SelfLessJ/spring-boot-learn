package com.chan.mybatis_xml.mapper;

import com.chan.mybatis_xml.entities.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chan
 * @create 2020-04-21 15:21
 */
@Mapper
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    int saveEmp(Employee emp);
}
