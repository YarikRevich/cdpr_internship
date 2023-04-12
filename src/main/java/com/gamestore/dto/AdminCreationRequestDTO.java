package com.gamestore.dto;

import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Data transfer object representing a request to create a new  admin with a specified user ID.
 * 
 * @author YarikRevich
 */
@Data
@Getter
@ToString
@NoArgsConstructor
public class AdminCreationRequestDTO {
    @Min(value = 0, message = "User id should be greater than 0")
    @JsonProperty("user_id")
    private long userId;
}

