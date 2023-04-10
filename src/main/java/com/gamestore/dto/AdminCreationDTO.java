package com.gamestore.dto;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@ToString
@NoArgsConstructor
public class AdminCreationDTO {
    @Min(value = 0, message = "User id should be greater than 0")
    @JsonProperty("user_id")
    private long userId;
}

