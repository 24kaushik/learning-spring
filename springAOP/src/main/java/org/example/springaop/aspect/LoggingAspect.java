package org.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//public class LoggingAspect {
//
//    @Before("execution(String org.example.springaop.service.StudentService.getAllStudents())")
//    public void logBeforeMethod(JoinPoint joinPoint) {
//        System.out.println("---------------------------------------------------");
//        System.out.println("Logging before method: " + joinPoint.getSignature().getName());
//    }
//
//    @AfterReturning(
//            value = "execution(String org.example.springaop.service.StudentService.getAllStudents())",
//            returning = "result"
//    )
//    public void logAfterMethod(JoinPoint joinPoint, String result) {
//        System.out.println("Logging after method: " + joinPoint.getSignature().getName());
//        System.out.println("The method returned: " + result);
//    }
//}
