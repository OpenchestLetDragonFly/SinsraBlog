package com.sinsra.aspect;/*
 * ClassName: myLogAspect
 * Package: com.sinsra.aspect
 * @Create: 2024/5/7 14:01
 */

import com.alibaba.fastjson.JSON;
import com.qiniu.util.Json;
import com.sinsra.annotation.mySystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class myLogAspect {

    @Pointcut("@annotation(com.sinsra.annotation.mySystemLog)")
    public void pt(){

    }

    @Around("pt()")
    public Object printLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object ret;
        try{
            handleBefore(proceedingJoinPoint);
            ret = proceedingJoinPoint.proceed();
            handleAfter(ret);
        } finally{
            log.info("=============end============"+System.lineSeparator());
        }
        //返回封装好的结果
        return ret;
    }

    private void handleBefore(ProceedingJoinPoint proceedingJoinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        mySystemLog systemLog = getSystemLog(proceedingJoinPoint);
        log.info("============start============");
        log.info("请求URL : {}", request.getRequestURI());
        log.info("接口描述 : {}", systemLog.businessName());
        log.info("请求方式 : {}", request.getMethod());
        log.info("请求类名 : {}", proceedingJoinPoint.getSignature());
        log.info("访问IP : {}", request.getRemoteHost());
        log.info("传入参数 : {}", JSON.toJSONString(proceedingJoinPoint.getArgs()));
    }

    private mySystemLog getSystemLog(ProceedingJoinPoint proceedingJoinPoint){
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        mySystemLog systemLog = methodSignature.getMethod().getAnnotation(mySystemLog.class);
        return systemLog;
    }

    private void handleAfter(Object ret){
        log.info("返回参数 : {}", JSON.toJSONString(ret));
    }

}
