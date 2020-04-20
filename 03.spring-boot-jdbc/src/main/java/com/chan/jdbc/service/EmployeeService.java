package com.chan.jdbc.service;

import com.chan.jdbc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author chan
 * @create 2020-04-20 22:04
 *
 * 使用Spring集成的JdbcTemplate进行数据库访问
 *   spring-boot在启动时会自动配置数据源
 *      1.在配置类中配置数据源连接配置；
 *      2.使用时注入DataSource对象；
 *      3.注入JdbcTemplate对象；
 *      4.即可进行数据库操作；
 */
@Service
public class EmployeeService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Connection connection;

    private RowMapper<Employee> rowMapper(){
        return (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setHireDate(rs.getDate("hire_date"));
            employee.setDept(rs.getString("dept"));
            return employee;
        };
    }

    /**
     * 查询指定员工
     * @param id
     * @return
     */
    public Employee getEmpById(Integer id){
        try {
            connection = dataSource.getConnection();

            Employee employee = jdbcTemplate.queryForObject("select * from employee where id = ?",
                    new Object[]{id}, rowMapper());

            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close(connection);
        }
        return null;
    }

    /**
     * 查询所有员工
     * @return
     */
    public List<Employee> getAll(){
        try {
            connection = dataSource.getConnection();

            List<Employee> employees = jdbcTemplate.query("select * from employee", rowMapper());
            return employees;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return null;
    }

    private void close(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
