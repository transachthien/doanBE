package com.example.doan.aop;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@RequiredArgsConstructor
public class checkLogAspect {
    @Around("@annotation(com.example.doan.aop.CheckLog)")
    public void aroundCheckLogAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CheckLog checkLog = method.getAnnotation(CheckLog.class);
        String value = checkLog.value();
        System.out.println("value :"+ value);
        joinPoint.proceed();
        value = value +"after";
        System.out.println("after value :"+ value);
    }
}
