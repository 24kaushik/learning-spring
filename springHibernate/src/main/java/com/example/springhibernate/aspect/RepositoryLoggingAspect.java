package com.example.springhibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RepositoryLoggingAspect {
    @Before("execution(* com.example.springhibernate.repository.*.*(..))")
    public void logBeforeRepositoryMethods(JoinPoint joinPoint) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Repository method: " + joinPoint.getSignature().getName());
    }
}
