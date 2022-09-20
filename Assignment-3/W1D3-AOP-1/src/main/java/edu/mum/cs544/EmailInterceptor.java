package edu.mum.cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Aspect
@Component
public class EmailInterceptor {

    private final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
    public void emailInterceptor(JoinPoint joinPoint){
        logger.warn("method "+joinPoint.getSignature().getName());
    }
}
