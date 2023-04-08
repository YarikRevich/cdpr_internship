package com.gamestore.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Data
@Getter
@ToString
public class GameDTO {
    @NonNull
    private String name;

    @NonNull
    private String genres;

    @NonNull
    private String email;

    @NonNull
    private String password;
}
