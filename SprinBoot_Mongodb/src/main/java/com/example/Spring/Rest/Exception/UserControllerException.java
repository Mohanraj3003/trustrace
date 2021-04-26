package com.example.Spring.Rest.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerException {

    @ExceptionHandler
   public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }




}
