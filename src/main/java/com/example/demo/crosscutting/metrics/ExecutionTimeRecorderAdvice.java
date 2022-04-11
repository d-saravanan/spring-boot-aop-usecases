package com.example.demo.crosscutting.metrics;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static java.lang.System.currentTimeMillis;

@Aspect
@Component
public class ExecutionTimeRecorderAdvice {

    @Around("@annotation(com.example.demo.crosscutting.metrics.TrackExecutionTime)")
    public Object track(ProceedingJoinPoint pjp) throws Throwable {

        long start = currentTimeMillis();
        Object result = pjp.proceed();
        long end = currentTimeMillis();
        System.out.println("Method: " + pjp.getSignature() + " took: " + (end - start) + " ms");
        return result;
    }

}
