package com.gamestore.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class DataValidationAdvice {
    Logger logger = LoggerFactory.getLogger(DataValidationAdvice.class);

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String handleNotFoundException(NotFoundException ex) {
      logger.error(ex.getMessage());
      return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String handleAlreadyExistsException(AlreadyExistsException ex) {
      logger.error(ex.getMessage());
      return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
      logger.error(ex.getMessage());
      return ex.getMessage();
    }
}
