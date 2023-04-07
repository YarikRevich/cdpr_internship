package com.example.practicaltask.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.practicaltask.entity.Game;
import com.example.practicaltask.service.GameService;

@RestController
public class GameController {
    @Autowired
    private GameService productService;

    @PostMapping(value = "v1/game", produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Game product){
        productService.createProduct(product); 
    }

    @GetMapping(value = "v1/game/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Game get(@PathVariable long id){
        return new Game();
    }

    @GetMapping(value = "v1/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<Game> get(){
        return productService.getAllProducts();
    }

    @DeleteMapping(value = "v1/game/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable long id) throws Exception{
        productService.deleteProduct(id); 
    }
}
