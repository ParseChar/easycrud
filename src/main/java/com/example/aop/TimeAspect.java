package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {
    @Pointcut("execution(* com.example.service.*.*(..))")
    private void pt(){}



    @Around("pt()")
    public Object readTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime=System.currentTimeMillis();
        //调用原始操作
        Object proceed = proceedingJoinPoint.proceed();
        Long endTime =System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature()+"运行了:{}毫秒",endTime-startTime);
        return proceed;
    }
    @Around("@annotation(com.example.aop.MyLog)")//详情看aop下MyLog注解
    public Object readTime2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime=System.currentTimeMillis();
        //调用原始操作
        Object proceed = proceedingJoinPoint.proceed();
        Long endTime =System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature()+"运行了:{}毫秒",endTime-startTime);
        return proceed;
    }
}
