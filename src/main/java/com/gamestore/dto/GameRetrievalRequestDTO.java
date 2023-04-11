package com.gamestore.dto;

import java.util.List;

import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gamestore.entity.Genre;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@Getter
@ToString
@NoArgsConstructor
public class GameRetrievalRequestDTO {
    @Min(value = 0, message = "Id should be greater than 0")
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("genres")
    private List<Genre> genres;

    @JsonProperty("price_lt")
    private int priceLessThan;

    @JsonProperty("price_gt")
    private int priceGreaterThan;

    @JsonProperty("available_quantity")
    private int availableQuantity;

    @JsonProperty("available_quantity_lt")
    private int availableQuantityLessThan;

    @JsonProperty("available_quantity_gt")
    private int availableQuantityGreaterThan;
}
