package com.gamestore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.gamestore.dto.GenreCreationRequestDTO;
import com.gamestore.dto.GenreCreationResponseDTO;
import com.gamestore.dto.GenreDeleteRequestDTO;
import com.gamestore.dto.GenreRetrievalRequestDTO;
import com.gamestore.dto.GenreRetrievalResponseDTO;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.GenreService;

@RestController
@Tag(name = "Genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping(value = "v1/genre", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GenreCreationResponseDTO create(@RequestBody @Validated GenreCreationRequestDTO genreCreationRequestDto) throws AlreadyExistsException {
        return this.genreService.create(genreCreationRequestDto); 
    }

    @GetMapping(value = "v1/genre", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GenreRetrievalResponseDTO get(@Validated GenreRetrievalRequestDTO genreRetrievalRequestDto) throws NotFoundException {
        return this.genreService.get(genreRetrievalRequestDto); 
    }

    @GetMapping(value = "v1/genres", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<GenreRetrievalResponseDTO> get(){
        return this.genreService.getAll();
    }

    @DeleteMapping(value = "v1/genre", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@Validated GenreDeleteRequestDTO genreDeleteRequestDto) throws NotFoundException {
        this.genreService.delete(genreDeleteRequestDto); 
    }
}
