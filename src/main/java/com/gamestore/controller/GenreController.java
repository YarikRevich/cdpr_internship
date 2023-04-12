package com.gamestore.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

/**
 * Controller for managing game genres catalogue.
 * 
 * @author YarikRevich
 */
@RestController
@Validated
@Tag(name = "Genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping(value = "v1/genre", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GenreCreationResponseDTO create(
        @RequestBody(description = "GenreCreationRequest", required = true,
                    content = @Content(
                            schema=@Schema(implementation = GenreCreationRequestDTO.class)))
        @Valid GenreCreationRequestDTO genreCreationRequestDto) throws AlreadyExistsException {
        return this.genreService.create(genreCreationRequestDto); 
    }

    @GetMapping(value = "v1/genre", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GenreRetrievalResponseDTO get(
        @RequestBody(description = "GenreRetrievalRequest", required = true,
        content = @Content(
                schema=@Schema(implementation = GenreRetrievalRequestDTO.class)))
        @Valid GenreRetrievalRequestDTO genreRetrievalRequestDto) throws NotFoundException {
        return this.genreService.get(genreRetrievalRequestDto); 
    }

    @GetMapping(value = "v1/genres", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<GenreRetrievalResponseDTO> get(){
        return this.genreService.getAll();
    }

    @DeleteMapping(value = "v1/genre", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(
        @RequestBody(description = "GenreDeleteRequest", required = true,
        content = @Content(
                schema=@Schema(implementation = GenreDeleteRequestDTO.class)))
        @Valid GenreDeleteRequestDTO genreDeleteRequestDto) throws NotFoundException {
        this.genreService.delete(genreDeleteRequestDto); 
    }
}
