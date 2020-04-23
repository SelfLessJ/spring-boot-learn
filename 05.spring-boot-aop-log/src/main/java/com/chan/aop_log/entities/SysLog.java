package com.chan.aop_log.entities;

import lombok.Data;

import java.util.Date;

/**
 * @author chan
 * @create 2020-04-23 10:33
 */
@Data
public class SysLog {

    private Integer id;
    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;

}
