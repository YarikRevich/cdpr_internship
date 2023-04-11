package com.gamestore.dto;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gamestore.entity.User;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Getter
@ToString
@NoArgsConstructor
public class AdminRetrievalResponseDTO {
    @Min(value = 0, message = "")
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("user")
    private User user;
}
