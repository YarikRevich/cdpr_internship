package com.gamestore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import com.gamestore.dto.GameCreationRequestDTO;
import com.gamestore.dto.UserCreationDTO;
import com.gamestore.entity.Game;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.GameService;
import com.gamestore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping(value = "v1/game", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody long create(@RequestBody @Validated GameCreationRequestDTO game) throws AlreadyExistsException {
        return 0;
        // return this.gameService.create(game);
    }

    @GetMapping(value = "v1/game/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Game get(@PathVariable long id) throws NotFoundException {
        return null;
        // return this.gameService.get(id);
    }

    @GetMapping(value = "v1/games", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Game> get() throws NotFoundException {
        return null;
        // return this.gameService.getAll();
    }

    @DeleteMapping(value = "v1/game/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(@PathVariable long id) throws NotFoundException {
        // this.gameService.delete(id);
    }
}
