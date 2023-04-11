package com.gamestore.dto;

import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@Getter
@ToString
@NoArgsConstructor
public class UserDeleteRequestDTO {
    @Min(value = 0, message = "Id should be greater than 0")
    @JsonProperty("id")
    private long id;
}
