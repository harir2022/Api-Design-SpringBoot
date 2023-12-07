package com.hari.webservice.restapi.exception;

import java.time.LocalDateTime;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hari.webservice.restapi.controller.UserController;

@ControllerAdvice
//@EnableWebMvc
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler{
     
     @ExceptionHandler(value = Exception.class)
     public final ResponseEntity<ErrorDetails> handleAllException(Exception exception ,  WebRequest req) throws Exception{
          ErrorDetails err = new ErrorDetails(exception.getMessage(), req.getDescription(false), LocalDateTime.now());
          return new ResponseEntity<ErrorDetails>(err,HttpStatus.INTERNAL_SERVER_ERROR);
     }

     @ExceptionHandler(value=UserNotFoundException.class)
     public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception exception ,  WebRequest req) throws Exception{
          ErrorDetails err = new ErrorDetails(exception.getMessage(), req.getDescription(false), LocalDateTime.now());
          return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
     }

}
