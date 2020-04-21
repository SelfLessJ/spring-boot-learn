package com.chan.mybatis_druid.entities;

import lombok.Data;

import java.util.Date;

/**
 * @author chan
 * @create 2020-04-20 22:07
 */
@Data
public class Employee {

    private Integer id;
    private String name;
    private Date hireDate;
    private String dept;
}