package com.gamestore.dto;

import java.time.LocalTime;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gamestore.entity.Cart;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Getter
@ToString
@NoArgsConstructor
public class OrderRetrievalResponseDTO {
    @Min(value = 0, message = "")
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("cart")
    private Cart cart;

    @NonNull
    @JsonProperty("creation_time")
    private LocalTime creationTime;
}
