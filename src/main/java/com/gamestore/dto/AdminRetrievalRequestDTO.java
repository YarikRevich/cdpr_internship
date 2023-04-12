package com.gamestore.dto;

import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Data transfer object representing a request to retrieve an admin account with a specified ID.
 * 
 * @author YarikRevich
 */
@Data
@Getter
@ToString
@NoArgsConstructor
public class AdminRetrievalRequestDTO {
    @Min(value = 0, message = "Id should be greater than 0")
    @JsonProperty("id")
    private long id;
}

