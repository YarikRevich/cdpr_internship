package com.gamestore.util.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.gamestore.util.exception.NotEnoughMoneyToBuyProductException;

@ControllerAdvice
public class NotEnoughMoneyToBuyProductAdvice {

    @ResponseBody
    @ExceptionHandler(NotEnoughMoneyToBuyProductException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notEnoughMoneyToBuyProductHandler(NotEnoughMoneyToBuyProductException ex) {
      return ex.getMessage();
    }
}
