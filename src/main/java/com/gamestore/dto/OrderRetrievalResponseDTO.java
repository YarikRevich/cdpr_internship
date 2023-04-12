package com.gamestore.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderRetrievalResponseDTO {
    @Min(value = 0, message = "")
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("cart")
    private CartRetrievalResponseDTO cart;

    @NonNull
    @JsonProperty("creation_time")
    private LocalDateTime creationTime;
}
