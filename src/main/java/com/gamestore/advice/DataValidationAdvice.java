package com.gamestore.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.gamestore.exception.UserNotFoundException;

@ControllerAdvice
public class DataValidationAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String handleUserNotFound(UserNotFoundException ex) {
      return ex.getMessage();
    }

    
}
