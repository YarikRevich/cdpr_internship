package com.gamestore.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@Getter
@ToString
@NoArgsConstructor
public class OrderCreationDTO {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String password;
}
