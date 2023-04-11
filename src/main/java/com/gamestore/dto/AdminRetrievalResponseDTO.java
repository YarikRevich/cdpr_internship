package com.gamestore.dto;

import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gamestore.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminRetrievalResponseDTO {
    @Min(value = 0, message = "Id should be greater than 0")
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("user")
    private UserRetrievalResponseDTO user;
}
