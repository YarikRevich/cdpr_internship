package com.gamestore.controller;

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
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.gamestore.entity.Game;
import com.gamestore.service.GameService;
import com.gamestore.service.GenreService;

@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping(value = "v1/genre", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> create(@RequestBody Game product){
        return genreService.create(product); 
    }

    @GetMapping(value = "v1/genre/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Game get(@PathVariable long id){
        return genreService.get(product); 
    }

    @GetMapping(value = "v1/genres", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<Game> get(){
        return genreService.getAllProducts();
    }

    @DeleteMapping(value = "v1/genre/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable long id) throws Exception{
        genreService.deleteProduct(id); 
    }
}
