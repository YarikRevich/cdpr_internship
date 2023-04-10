package com.gamestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gamestore.GameStoreApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Game store API", version = "1.0"))
public class GameStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(GameStoreApplication.class, args);
	}
}
