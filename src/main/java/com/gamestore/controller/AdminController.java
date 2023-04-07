package com.example.practicaltask.controller;

package com.example.practicaltask.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.practicaltask.entity.User;
import com.example.practicaltask.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> create(@RequestBody User user){
        // userService.create(user);
    }

    @GetMapping(value = "v1/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<User> get(@PathVariable long id){
        // return new User();
    }

    @GetMapping(value = "v1/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<User>> get(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        // return userService.get();
    }

    @DeleteMapping(value = "v1/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> delete(@PathVariable long id) throws Exception{
        // return userService.delete(id);
    }
}

