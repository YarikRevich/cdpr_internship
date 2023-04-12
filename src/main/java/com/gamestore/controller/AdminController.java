package com.gamestore.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller for managing admin accounts.
 * 
 * @author YarikRevich
 */
@RestController
@Validated
@Tag(name = "Admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody AdminCreationResponseDTO create(
        @RequestBody(description = "AdminCreationRequest", required = true,
                    content = @Content(
                            schema=@Schema(implementation = AdminCreationRequestDTO.class))) 
        @Valid AdminCreationRequestDTO adminCreationRequestDto) throws AlreadyExistsException {
        logger.info("POST 'v1/admin' is accessed with the following parameters: %s", adminCreationRequestDto);
        return this.adminService.create(adminCreationRequestDto);
    }

    @GetMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody AdminRetrievalResponseDTO get(
        @RequestBody(description = "AdminRetrievalRequest", required = true,
                    content = @Content(
                            schema=@Schema(implementation = AdminRetrievalRequestDTO.class))) 
        @Valid AdminRetrievalRequestDTO adminRetrievalRequestDto) throws NotFoundException {
        logger.info("GET 'v1/admin' is accessed with the following parameters: %s", adminRetrievalRequestDto);
        return this.adminService.get(adminRetrievalRequestDto);
    }

    @GetMapping(value = "v1/admins", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<AdminRetrievalResponseDTO> get() throws NotFoundException {
        logger.info("GET 'v1/admins' is accessed");
        return this.adminService.getAll();
    }

    @DeleteMapping(value = "v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(
        @RequestBody(description = "AdminDeleteRequest", required = true,
                    content = @Content(
                            schema=@Schema(implementation = AdminDeleteRequestDTO.class))) 
        @Valid AdminDeleteRequestDTO adminDeleteRequestDto) throws NotFoundException {
        this.adminService.delete(adminDeleteRequestDto);
    }
}

