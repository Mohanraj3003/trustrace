package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;



@Aspect
@Component
public class AopClass {

    @ExceptionHandler
    public ResponseEntity handleIllegalArgumentException(JoinPoint jp,IllegalArgumentException e){
        System.out.println(jp.getSignature());
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleException(JoinPoint jp,Exception e){
        System.out.println(jp.getSignature());
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
