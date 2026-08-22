package org.example.springaop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Aspect
public class SampleAspect {
    @Around("@annotation(org.example.springaop.annotation.TrackExecutionTime)")
    public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        long time = endTime - startTime;
        System.out.println("Executed " + joinPoint.getSignature().getName() + " in " + time + " ms");
        return res;
    }
}
