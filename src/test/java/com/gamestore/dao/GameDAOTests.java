package com.gamestore.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

import com.gamestore.dao.UserDAO;
import com.gamestore.entity.Game;
import com.gamestore.practicaltask.dao.ProductDAO;
import com.gamestore.practicaltask.util.dataloader.DataLoader;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Unit tests for ProductDao
 */
@Import({DataLoader.class, ProductDAO.class, UserDAO.class})
@DataJpaTest
public class GameDAOTests {
    @Autowired
    private ProductDAO productDao;

    @BeforeEach
    public void setUp() throws Exception{
        ArrayList<Game> products = productDao.getAllProducts();
        for (Game product : products){
            productDao.deleteProduct(product.getId());
        };
    }

    @Test
    public void testCreateProduct(){}

    @Test
    public void testDeleteProduct(){}
}
