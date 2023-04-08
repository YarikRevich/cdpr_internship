package com.gamestore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.gamestore.dto.UserDTO;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody long create(@RequestBody UserDTO user) throws AlreadyExistsException {
        return this.userService.create(user);
    }

    @GetMapping(value = "v1/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User get(@PathVariable long id) throws NotFoundException {
        return this.userService.get(id);
    }

    @GetMapping(value = "v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> get() throws NotFoundException {
        return this.userService.getAll();
    }

    @DeleteMapping(value = "v1/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(@PathVariable long id) throws NotFoundException {
        this.userService.delete(id);
    }
}
