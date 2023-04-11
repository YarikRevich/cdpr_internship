package com.gamestore.dto;


public class CartCreationRequestDTO {
    @Min(value = 0, message = "Id should be greater than 0")
}
