package com.gamestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;
}
