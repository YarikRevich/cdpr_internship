package com.gamestore.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import com.gamestore.dto.AdminCreationRequestDTO;
import com.gamestore.dto.AdminCreationResponseDTO;
import com.gamestore.dto.AdminDeleteRequestDTO;
import com.gamestore.dto.AdminRetrievalRequestDTO;
import com.gamestore.dto.AdminRetrievalResponseDTO;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.AdminService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@Validated
@Tag(name = "Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody AdminCreationResponseDTO create(@Valid @RequestBody AdminCreationRequestDTO adminCreationRequestDto) throws AlreadyExistsException {
        return this.adminService.create(adminCreationRequestDto);
    }

    @GetMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody AdminRetrievalResponseDTO get(@Valid AdminRetrievalRequestDTO adminRetrievalRequestDto) throws NotFoundException {
        return this.adminService.get(adminRetrievalRequestDto);
    }

    @GetMapping(value = "v1/admins", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<AdminRetrievalResponseDTO> get() throws NotFoundException {
        return this.adminService.getAll();
    }

    @DeleteMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(@Valid AdminDeleteRequestDTO adminDeleteRequestDto) throws NotFoundException {
        this.adminService.delete(adminDeleteRequestDto);
    }
}

