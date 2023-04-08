package com.gamestore.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.gamestore.entity.Game;
import com.gamestore.repository.AdminRepository;
import com.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.gamestore.util.exception.ProductNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Dao service which interects with product repository
 */
@Component
public class AdminDAO {
    @Autowired
    private AdminRepository adminRepository;

    public 

    public int getProductPrice(long id) throws Exception{
        Game product = null;
        if (productRepository.existsById(id)){
            product = productRepository.getById(id);
        } else {
            throw new ProductNotFoundException();
        }
        return product.getPrice();
    }

    public Game getProductById(long id) throws Exception{
        Game product = null;
        if (productRepository.existsById(id)){
            product = productRepository.getById(id);
        } else {
            throw new ProductNotFoundException();
        }
        return product;
    }
    
    public ArrayList<Game> getAllProducts(){
        return new ArrayList<Game>(productRepository.findAll());
    }

    /**
     * Creates new product to product repository
     */
    public void createProduct(Game product){
        productRepository.save(product);
    }

    /**
     * Deletes product from product repository
     */
    public void deleteProduct(long id) throws Exception{
        productRepository.delete(this.getProductById(id));
    }
}
