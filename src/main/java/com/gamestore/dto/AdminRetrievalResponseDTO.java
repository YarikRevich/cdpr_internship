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

/**
 * Data Transfer Object (DTO) for Admin retrieval response.
 * Contains the id of the admin and a UserRetrievalResponseDTO object representing the user associated with the admin.
 * 
 * @author YarikRevich
 */
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
