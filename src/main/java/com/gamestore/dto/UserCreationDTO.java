package com.gamestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@Getter
@ToString
@NoArgsConstructor
public class UserCreationDTO {
    @NonNull
    @JsonProperty("first_name")
    private String firstName;

    @NonNull
    @JsonProperty("last_name")
    private String lastName;

    @NonNull
    @JsonProperty("email")
    private String email;

    @NonNull
    @JsonProperty("password")
    private String password;
}
