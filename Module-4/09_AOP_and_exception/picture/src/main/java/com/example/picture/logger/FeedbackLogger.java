package com.example.picture.logger;

import com.example.picture.service.exception.BadFeedbackException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class FeedbackLogger {
    @AfterThrowing(pointcut = "execution(public * com.example.picture.controller.FeedbackController.post(..))", throwing = "ex")
    public void logBadFeedback(JoinPoint joinPoint, BadFeedbackException ex) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("Error occur: %s.%s%s", className, method, args));
        System.out.println(ex.getMessage());
    }
}
