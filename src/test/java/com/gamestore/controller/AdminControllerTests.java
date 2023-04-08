package com.gamestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminControllerTests {
    @Autowired
	private AdminController adminController;

    @Value(value="${local.server.port}")
	private int port;

    
}
