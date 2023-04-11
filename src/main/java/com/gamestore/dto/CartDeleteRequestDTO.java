package com.gamestore.dto;

public class CartDeleteRequestDTO {
    @Min(value = 0, message = "Id should be greater than 0")
    @JsonProperty("id")
    private long id;
}
