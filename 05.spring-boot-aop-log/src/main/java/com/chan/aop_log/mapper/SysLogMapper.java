package com.chan.aop_log.mapper;

import com.chan.aop_log.entities.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chan
 * @create 2020-04-23 10:36
 */
@Mapper
public interface SysLogMapper {


    @Insert("INSERT INTO sys_log(username,operation,time,method,ip,params,create_time) VALUES(#{username},#{operation},#{time},#{method},#{ip},#{params},#{createTime})")
    void saveSysLog(SysLog sysLog);
}
