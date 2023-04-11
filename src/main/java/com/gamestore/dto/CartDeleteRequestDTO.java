package com.gamestore.dto;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartDeleteRequestDTO {
    @Min(value = 0, message = "Id should be greater than 0")
    @JsonProperty("id")
    private long id;
}
