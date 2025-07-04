package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class LoggingAspect {

    @Before("execution(* com.example.service.BookService.addBook(..))")
    public void beforeAddBook(JoinPoint joinPoint) {
        System.out.println("🔍 [Before] Executing method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.service.BookService.addBook(..))")
    public void afterAddBook(JoinPoint joinPoint) {
        System.out.println("✅ [After] Finished method: " + joinPoint.getSignature().getName());
    }
}
