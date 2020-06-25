package com.sise.log;

import com.sise.domain.SysLog;
import com.sise.domain.SysUser;
import com.sise.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    LogService logService;

    @Pointcut("execution(* com.sise.controller.*.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object arround(ProceedingJoinPoint joinPoint){

        //获取访问时间
        Date visitTime = new Date();

        //获取访问用户名
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();

        //获取远程地址
        String address = request.getRemoteAddr();

        //获取全限定类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取方法名
        String method = joinPoint.getSignature().getName();


        SysLog log = new SysLog(visitTime, username, address, className + "." + method);

        logService.save(log);

        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;

    }
}
