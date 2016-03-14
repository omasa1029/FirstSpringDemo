package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ServiceLogging {

    @Around("execution(* com.example.service.*.*(..))")
    public Object aroundLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();

        log.info(signature.toString() + ": Start.");
        Object object = proceedingJoinPoint.proceed();
        log.info(signature.toString() + ": End.");

        return object;
    }
}
