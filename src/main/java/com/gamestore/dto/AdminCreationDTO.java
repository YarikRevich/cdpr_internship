package com.gamestore.dto;

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
    @JsonProperty("user_id")
    private long userId;
}

