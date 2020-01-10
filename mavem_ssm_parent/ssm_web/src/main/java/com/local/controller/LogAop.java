package com.local.controller;

import com.local.domain.SysLog;
import com.local.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.Security;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    private Date visitTime;
    private Class clazz;
    private Method method;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    LogService service;

    //前置通知，获取开始时间，执行的类是哪一个，执行的方法
    @Before("execution(* com.local.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();//开始要执行的时间
        clazz = joinPoint.getTarget().getClass();//获取执行的类
        String methodName = joinPoint.getSignature().getName(); //获取方法的名字
        Object[] args = joinPoint.getArgs();//获取访问的方法的参数
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    //后置通知
    @After("execution(* com.local.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        Long time = new Date().getTime() - visitTime.getTime();//获取访问的时长
        String url = ""; //获取的资源路径
        if (clazz != null && method != null && clazz != LogAop.class) {
            //获取类上注解的值
            RequestMapping classannotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classannotation != null) {
                String classvalue = classannotation.value()[0];
                // String split = value.split("/")[1];
                RequestMapping methodannotation = method.getAnnotation(RequestMapping.class);
                if (methodannotation != null) {
                    String methodValue = methodannotation.value()[0];
                    url = classvalue + methodValue;
                }
            }
        }
        String remoteAddr = request.getRemoteAddr();//获取访问地址
        SecurityContext context = SecurityContextHolder.getContext();//从上下文获取正在登陆的用户
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();//获取用户的用户名
        //将相关信息封装到实体类
        SysLog log = new SysLog();
        log.setIp(remoteAddr);
        log.setUsername(username);
        log.setUrl(url);
        log.setExecutionTime(time);
        log.setMethod("【类名】" + clazz.getName() + "【方法名】" + method.getName());
        log.setVisitTime(visitTime);

        //调用service完成数据的保存
        service.savelog(log);
    }
}
