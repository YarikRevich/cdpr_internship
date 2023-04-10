package com.gamestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gamestore.GameStoreApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class GameStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(GameStoreApplication.class, args);
	}
}
