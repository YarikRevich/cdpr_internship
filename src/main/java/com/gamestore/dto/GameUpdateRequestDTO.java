package com.gamestore.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gamestore.entity.Genre;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@Getter
@ToString
@NoArgsConstructor
public class GameUpdateRequestDTO {
    @NonNull
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("genres")
    private List<Genre> genres;

    @JsonProperty("price")
    private int price;

    @JsonProperty("available_quantity")
    private int availableQuantity;
}
