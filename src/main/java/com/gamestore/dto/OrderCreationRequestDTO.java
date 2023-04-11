package com.gamestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@Getter
@ToString
@NoArgsConstructor
public class OrderCreationRequestDTO {
    @JsonProperty("cart_id")
    private long cartId;
}
