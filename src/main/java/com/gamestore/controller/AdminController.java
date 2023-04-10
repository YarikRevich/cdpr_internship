package com.gamestore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import com.gamestore.dto.AdminCreationDTO;
import com.gamestore.entity.Admin;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.AdminService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@Tag(name = "Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody long create(@RequestBody @Validated AdminCreationDTO adminCreationRequestDto) throws AlreadyExistsException {
        return this.adminService.create(adminCreationRequestDto);
    }

    @GetMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Admin get(@RequestParam(name = "id") long id) throws NotFoundException {
        return this.adminService.get(id);
    }

    @GetMapping(value = "v1/admins", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Admin> get() throws NotFoundException {
        return this.adminService.getAll();
    }

    @DeleteMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(@RequestParam(name = "id") long id) throws NotFoundException {
        this.adminService.delete(id);
    }
}

