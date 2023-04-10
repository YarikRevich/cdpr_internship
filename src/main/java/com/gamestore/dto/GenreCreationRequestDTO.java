package com.gamestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Getter
@ToString
@NoArgsConstructor
public class GenreCreationRequestDTO {
    @NonNull
    @JsonProperty("name")
    private String name;
}
