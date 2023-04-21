package com.example.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.mapper.OperateLogMapper;
import com.example.pojo.OperateLog;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Around("@annotation(com.example.anno.Log)")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取id
        String jwt = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");
        //获取操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        //获取操作类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取操作方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        //获取操作方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        //获取操作方法返回值
        //获取操作耗时
        Long start = System.currentTimeMillis();
        Object returnValue1 = proceedingJoinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long costTime = end - start;
        String resultValue = JSONObject.toJSONString(returnValue1);
        operateLogMapper.insert(new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, resultValue, costTime));
        return returnValue1;
    }
}
