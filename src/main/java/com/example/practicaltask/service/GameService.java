package com.example.practicaltask.service;

import java.util.ArrayList;

import com.example.practicaltask.dao.GameDAO;
import com.example.practicaltask.entity.Game;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Services, which are used in "games" scope
 */
@Service
public class GameService {
    @Autowired
    private GameDAO gameDao;

    /**
     * Creates certain product
     * @param product product to be created
     */
    public void createProduct(Game product){
        productDao.createProduct(product);
    }

    /**
     * Deletes certain product
     * @param product product to be deleted
     */
    public void deleteProduct(long id) throws Exception{
        productDao.deleteProduct(id);
    }

    /**
     * Lists all the existing products
     * @return list of all existing products
     */
    public ArrayList<Game> getAllProducts(){
        return productDao.getAllProducts();
    }
}
