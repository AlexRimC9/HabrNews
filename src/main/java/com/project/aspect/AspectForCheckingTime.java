package com.project.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectForCheckingTime {

    @Around("@annotation(com.project.annotation.CheckingTime)")
    public Object logCheckingTime(ProceedingJoinPoint point) throws Throwable{
        long afterStart = System.currentTimeMillis();
        Object proceed = point.proceed();
        long beforeStart =  System.currentTimeMillis() - afterStart;
        log.info(point.getSignature() + " executed in " + beforeStart + "ms");
        return proceed;
    }
}
