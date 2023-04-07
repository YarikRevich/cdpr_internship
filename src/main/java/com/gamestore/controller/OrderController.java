package com.example.practicaltask.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import com.example.practicaltask.entity.Game;
import com.example.practicaltask.entity.User;
import com.example.practicaltask.entity.wrapper.BuyProductWrapper;

import com.example.practicaltask.service.OrderService;


import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("transactions")
public class OrderController {
    @Autowired
    private OrderService transactionService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void buyProduct(@RequestBody BuyProductWrapper buyProductWrapper) throws Exception {
        transactionService.buyProduct(buyProductWrapper);
    }

    @RequestMapping(value = "/getAllProductsByUserId/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<Game> getAllProductsByUserId(@PathVariable int id) throws Exception{
        return transactionService.getAllProductsByUserId(id);
    }

    @RequestMapping(value = "/getAllUsersByProductId/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<User> getAllUsersByProductId(@PathVariable int id) throws Exception {
        return transactionService.getAllUsersByProductId(id);
    }
}
