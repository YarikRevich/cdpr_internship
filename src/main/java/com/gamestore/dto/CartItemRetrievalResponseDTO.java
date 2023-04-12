package com.gamestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Data
@Getter
@ToString
@AllArgsConstructor
public class CartItemRetrievalResponseDTO {
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("user")
    private UserRetrievalResponseDTO user;

    @NonNull
    @JsonProperty("game")
    private GameRetrievalResponseDTO game;

    @JsonProperty("quantity")
    private int quantity;
}

 



