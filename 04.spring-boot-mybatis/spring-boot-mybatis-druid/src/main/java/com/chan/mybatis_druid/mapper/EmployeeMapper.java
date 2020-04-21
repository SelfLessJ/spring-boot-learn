package com.chan.mybatis_druid.mapper;

import com.chan.mybatis_druid.entities.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author chan
 * @create 2020-04-21 15:21
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT id,name,hire_date,dept from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Insert("INSERT INTO employee(name,hire_date,dept) VALUES (#{name},#{hireDate},#{dept})")
    int saveEmp(Employee emp);
}
