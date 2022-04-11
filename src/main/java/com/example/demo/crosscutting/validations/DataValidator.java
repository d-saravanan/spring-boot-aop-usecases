package com.example.demo.crosscutting.validations;

import com.example.demo.validations.EntityValidator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Aspect
@Component
public class DataValidator {

    @Around("@annotation(com.example.demo.crosscutting.validations.EnforceAutoEntityDataValidation)")
    public void enforceDataValidation(ProceedingJoinPoint pjp) {

        Object[] args = pjp.getArgs();

        if (isNull(args) || args.length < 1) return;

        for (Object arg : args) {
            if (arg instanceof EntityValidator) {
                ((EntityValidator) arg).validate();
            }
        }

    }
}
