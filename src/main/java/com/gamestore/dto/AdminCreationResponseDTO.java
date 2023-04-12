package com.gamestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

/**
 * Data transfer object representing the response from creating a new admin account.
 * 
 * @author YarikRevich
 */
@Data
@Getter
@ToString
@NoArgsConstructor
public class AdminCreationResponseDTO {
    @JsonProperty("id")
    private long id;
}
