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
public class GameRetrievalResponseDTO {
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("name")
    private String name;
    
    @NonNull
    @JsonProperty("genres")
    private List<GenreRetrievalResponseDTO> genres;

    @JsonProperty("price")
    private int price;

    @JsonProperty("available_quantity")
    private int availableQuantity;
}
