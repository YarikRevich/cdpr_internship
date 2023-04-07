package com.example.practicaltask.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

import com.example.practicaltask.dao.UserDao;
import com.example.practicaltask.dao.ProductDao;
import com.example.practicaltask.entity.Product;
import com.example.practicaltask.util.dataloader.DataLoader;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Unit tests for ProductDao
 */
@Import({DataLoader.class, ProductDao.class, UserDao.class})
@DataJpaTest
public class ProductDaoTests {
    @Autowired
    private ProductDao productDao;

    @BeforeEach
    public void setUp() throws Exception{
        ArrayList<Product> products = productDao.getAllProducts();
        for (Product product : products){
            productDao.deleteProduct(product.getId());
        };
    }

    @Test
    public void testCreateProduct(){}

    @Test
    public void testDeleteProduct(){}
}
