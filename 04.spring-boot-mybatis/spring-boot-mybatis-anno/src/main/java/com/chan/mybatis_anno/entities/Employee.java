package com.chan.mybatis_anno.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date hireDate;
    private String dept;
}
