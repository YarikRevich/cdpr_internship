package com.gamestore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.gamestore.controller.AdminController;
import com.gamestore.controller.CartController;
import com.gamestore.controller.GameController;
import com.gamestore.controller.GenreController;
import com.gamestore.controller.OrderController;
import com.gamestore.controller.UserController;
import com.gamestore.dao.AdminDAO;
import com.gamestore.dao.CartDAO;
import com.gamestore.dao.GameDAO;
import com.gamestore.dao.GenreDAO;
import com.gamestore.dao.OrderDAO;
import com.gamestore.dao.UserDAO;
import com.gamestore.service.AdminService;
import com.gamestore.service.GameService;
import com.gamestore.service.GenreService;
import com.gamestore.service.OrderService;
import com.gamestore.service.UserService;

@EnableAutoConfiguration
@Import({AdminController.class, AdminService.class, AdminDAO.class, CartController.class, CartDAO.class, GameController.class, GameService.class, GameDAO.class, GenreController.class, GenreService.class, GenreDAO.class, OrderController.class, OrderService.class, OrderDAO.class, UserController.class, UserService.class, UserDAO.class})
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
