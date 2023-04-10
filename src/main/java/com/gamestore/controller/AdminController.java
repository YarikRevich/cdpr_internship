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

import com.gamestore.dto.AdminCreationDTO;
import com.gamestore.entity.Admin;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody long create(@RequestBody AdminCreationDTO admin) throws AlreadyExistsException {
        return this.adminService.create(admin);
    }

    @GetMapping(value = "v1/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Admin get(@PathVariable long id) throws NotFoundException {
        return this.adminService.get(id);
    }

    @GetMapping(value = "v1/admins", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Admin> get() throws NotFoundException {
        return this.adminService.getAll();
    }

    @DeleteMapping(value = "v1/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(@PathVariable long id) throws NotFoundException {
        this.adminService.delete(id);
    }
}

