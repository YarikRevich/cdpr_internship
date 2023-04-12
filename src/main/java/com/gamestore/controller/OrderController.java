package com.gamestore.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import com.gamestore.dto.OrderCreationRequestDTO;
import com.gamestore.dto.OrderCreationResponseDTO;
import com.gamestore.dto.OrderDeleteRequestDTO;
import com.gamestore.dto.OrderRetrievalRequestDTO;
import com.gamestore.dto.OrderRetrievalResponseDTO;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

/**
 * Controller for managing account orders.
 * 
 * @author YarikRevich
 */
@RestController
@Validated
@Tag(name = "Order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "v1/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody OrderCreationResponseDTO create(
        @RequestBody(description = "OrderCreationRequest", required = true,
                    content = @Content(
                            schema=@Schema(implementation = OrderCreationRequestDTO.class)))
        @Valid OrderCreationRequestDTO orderCreationRequestDto) throws AlreadyExistsException, NotFoundException {
        return this.orderService.create(orderCreationRequestDto);
    }

    @GetMapping(value = "v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody OrderRetrievalResponseDTO get(
        @RequestBody(description = "OrderRetrievalRequest", required = true,
        content = @Content(
                schema=@Schema(implementation = OrderRetrievalRequestDTO.class)))
        @Valid OrderRetrievalRequestDTO orderRetrievalRequestDTo) throws NotFoundException {
        return this.orderService.get(orderRetrievalRequestDTo);
    }

    @GetMapping(value = "v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<OrderRetrievalResponseDTO> get() throws NotFoundException {
        return this.orderService.getAll();
    }

    @DeleteMapping(value = "v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void delete(
        @RequestBody(description = "OrderDeleteRequest", required = true,
        content = @Content(
                schema=@Schema(implementation = OrderDeleteRequestDTO.class)))
        @Valid OrderDeleteRequestDTO orderDeleteRequestDto) throws NotFoundException {
        this.orderService.delete(orderDeleteRequestDto);
    }
}
