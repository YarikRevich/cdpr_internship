package com.gamestore.dto;

import java.util.List;

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
public class CartRetrievalResponseDTO {
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("user")
    private UserRetrievalResponseDTO user;

    @NonNull
    @JsonProperty("cart_items")
    private List<CartItemRetrievalResponseDTO> cartItems;
}