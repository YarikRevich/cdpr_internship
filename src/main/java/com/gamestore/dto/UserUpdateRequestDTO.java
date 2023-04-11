package com.gamestore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

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
public class UserUpdateRequestDTO {
    @Min(value = 0, message = "Id should be greater than 0")
    @JsonProperty("id")
    private long id;

    @NonNull
    @JsonProperty("first_name")
    private String firstName;

    @NonNull
    @JsonProperty("last_name")
    private String lastName;

    @Email
    @NonNull
    @JsonProperty("email")
    private String email;

    @NonNull
    @JsonProperty("password")
    private String password;
}
