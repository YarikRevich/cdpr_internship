package com.gamestore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gamestore.controller.AdminController;
import com.gamestore.controller.CartController;
import com.gamestore.controller.GameController;
import com.gamestore.controller.GenreController;
import com.gamestore.controller.OrderController;
import com.gamestore.controller.UserController;

@SpringBootTest
class GameStoreApplication {
	@Autowired
	private AdminController adminController;

	@Autowired
	private CartController cartController;

	@Autowired
	private GameController gameController;

	@Autowired
	private GenreController genreController;
	
	@Autowired
	private OrderController orderController;

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
		assertThat(adminController).isNotNull();
		assertThat(cartController).isNotNull();
		assertThat(gameController).isNotNull();
		assertThat(genreController).isNotNull();
		assertThat(orderController).isNotNull();
		assertThat(userController).isNotNull();
	}


}
