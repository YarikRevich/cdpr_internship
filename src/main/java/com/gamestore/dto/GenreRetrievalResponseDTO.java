package com.gamestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GenreRetrievalResponseDTO {
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("name")
    private String name;
}
