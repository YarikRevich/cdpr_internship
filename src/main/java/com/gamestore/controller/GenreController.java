package com.gamestore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamestore.dto.GenreCreationDTO;
import com.gamestore.entity.Genre;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.GenreService;

@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping(value = "v1/genre", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody long create(@RequestBody GenreCreationDTO genre) throws AlreadyExistsException {
        return genreService.create(genre); 
    }

    @GetMapping(value = "v1/genre/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Genre get(@PathVariable long id) throws NotFoundException {
        return genreService.get(id); 
    }

    @GetMapping(value = "v1/genres", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Genre> get(){
        return genreService.getAll();
    }

    @DeleteMapping(value = "v1/genre/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable long id) throws NotFoundException {
        genreService.delete(id); 
    }
}
