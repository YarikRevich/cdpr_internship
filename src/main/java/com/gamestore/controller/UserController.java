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

import com.gamestore.dto.UserCreationRequestDTO;
import com.gamestore.dto.UserCreationResponseDTO;
import com.gamestore.dto.UserDeleteRequestDTO;
import com.gamestore.dto.UserRetrievalRequestDTO;
import com.gamestore.dto.UserRetrievalResponseDTO;
import com.gamestore.dto.UserUpdateRequestDTO;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@Tag(name = "User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "v1/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserCreationResponseDTO create(@RequestBody @Validated UserCreationRequestDTO userCreationRequestDto) throws AlreadyExistsException {
        return this.userService.create(userCreationRequestDto);
    }

    @GetMapping(value = "v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserRetrievalResponseDTO get(@Validated UserRetrievalRequestDTO userRetrievalRequestDto) throws NotFoundException {
        return this.userService.get(userRetrievalRequestDto);
    }

    @GetMapping(value = "v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UserRetrievalResponseDTO> get() throws NotFoundException {
        return this.userService.getAll();
    }

    @PutMapping(value = "v1/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody @Validated UserUpdateRequestDTO userUpdateRequestDto) throws NotFoundException {
        this.userService.update(userUpdateRequestDto); 
    }

    @DeleteMapping(value = "v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(@Validated UserDeleteRequestDTO userDeleteRequestDto) throws NotFoundException {
        this.userService.delete(id);
    }
}
