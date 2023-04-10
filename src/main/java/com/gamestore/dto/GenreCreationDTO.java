package com.gamestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Data
@Getter
@ToString
public class GenreCreationDTO {
    @NonNull
    @JsonProperty("name")
    private String name;
}
