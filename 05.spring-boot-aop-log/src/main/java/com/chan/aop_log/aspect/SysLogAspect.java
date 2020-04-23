package com.chan.aop_log.aspect;

import com.chan.aop_log.annotation.Log;
import com.chan.aop_log.entities.SysLog;
import com.chan.aop_log.mapper.SysLogMapper;
import com.chan.aop_log.utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author chan
 * @create 2020-04-23 10:46
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Pointcut("@annotation(com.chan.aop_log.annotation.Log)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object saveLog(ProceedingJoinPoint point) {
        Object result = null;


        long start = System.currentTimeMillis();
        try {
            //执行业务代码
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //统计执行时长
        long time = System.currentTimeMillis() - start;

        //保存日志
        saveLog(point, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point, long time) {
        SysLog sysLog = new SysLog();

        //默认用户
        sysLog.setUsername("chan");

        //获取方法签名
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        //用户操作：即为注解的描述
        Log log = method.getAnnotation(Log.class);
        if (log != null) {
            sysLog.setOperation(log.value());
        }

        //访问请求方法：类名:方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getMethod().getName();
        sysLog.setMethod(className + ": " + methodName);

        //访问请求参数：参数名: 参数值 ...
        Object[] args = point.getArgs();

        LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = parameterNameDiscoverer.getParameterNames(method);

        if (paramNames != null && args != null) {
            StringBuilder params = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                params.append("  ").append(paramNames[i]).append(": ").append(args[i]);
            }
            sysLog.setParams(params.toString());
        } else {
            sysLog.setParams(null);
        }

        //IP地址
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String ip = IPUtils.getIpAddr(request);
        sysLog.setIp(ip);

        //响应时间和创建时间
        sysLog.setTime((int) time);
        sysLog.setCreateTime(new Date());

        //存入数据库
        sysLogMapper.saveSysLog(sysLog);
    }
}
