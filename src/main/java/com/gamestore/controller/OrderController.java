package com.gamestore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import com.gamestore.dto.OrderCreationDTO;
import com.gamestore.dto.UserCreationDTO;
import com.gamestore.entity.Order;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.OrderService;
import com.gamestore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "v1/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody long create(@RequestBody @Validated OrderCreationDTO user) throws AlreadyExistsException {
        //return this.orderService.create(user);
        return 0;
    }

    @GetMapping(value = "v1/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Order get(@PathVariable long id) throws NotFoundException {
        // return this.orderService.get(id);
        return null;
    }

    @GetMapping(value = "v1/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Order> get() throws NotFoundException {
        return null;
        // return this.orderService.getAll();
    }

    @DeleteMapping(value = "v1/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(@RequestParam(name = "id") long id) throws NotFoundException {
        // this.orderService.delete(id);
    }
}
