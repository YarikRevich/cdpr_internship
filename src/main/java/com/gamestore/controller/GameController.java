package com.gamestore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import com.gamestore.dto.GameCreationRequestDTO;
import com.gamestore.dto.GameCreationResponseDTO;
import com.gamestore.dto.GameDeleteRequestDTO;
import com.gamestore.dto.GameRetrievalRequestDTO;
import com.gamestore.dto.GameRetrievalResponseDTO;
import com.gamestore.dto.GameUpdateRequestDTO;
import com.gamestore.dto.UserCreationRequestDTO;
import com.gamestore.entity.Game;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.GameService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@Tag(name = "Game")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping(value = "v1/game", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GameCreationResponseDTO create(@RequestBody @Validated GameCreationRequestDTO gameCreationRequestDto) throws AlreadyExistsException {
        return this.gameService.create(gameCreationRequestDto);
    }

    @GetMapping(value = "v1/game", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GameRetrievalResponseDTO get(@Validated GameRetrievalRequestDTO gameRetrievalRequestDto) throws NotFoundException {
        return this.gameService.get(gameRetrievalRequestDto);
    }

    @GetMapping(value = "v1/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<GameRetrievalResponseDTO> get() throws NotFoundException {
        return this.gameService.getAll();
    }

    @PutMapping(value = "v1/game", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody @Validated GameUpdateRequestDTO gameUpdateRequestDto) throws NotFoundException {
        this.gameService.update(gameUpdateRequestDto); 
    }

    @DeleteMapping(value = "v1/game", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(@Validated GameDeleteRequestDTO gameDeleteRequestDto) throws NotFoundException {
        this.gameService.delete(gameDeleteRequestDto);
    }
}
