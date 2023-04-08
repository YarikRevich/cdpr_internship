package com.gamestore.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.gamestore.repository.UserRepository;
import com.gamestore.repository.GameRepository;
import com.gamestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.gamestore.util.exception.NotEnoughMoneyToBuyProductException;
import com.gamestore.util.exception.ProductNotFoundException;
import com.gamestore.util.exception.UserNotFoundException;

import com.gamestore.entity.User;
import com.gamestore.entity.Game;
import com.gamestore.entity.Order;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class OrderDAO {
    @Autowired
    private GameRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository transactionRepository;

      /**
     * Displays all the products bought by certain user
     * @param id id of the user
     * @return list of products bought by user with certain id
     */
    public ArrayList<Game> getAllProductsByUserId(long id) throws Exception{
        User user = null;
        if (userRepository.existsById(id)){
            user = userRepository.getReferenceById(id);
        } else {
            throw new NotFoundException();
        }
        ArrayList<Game> products = new ArrayList<>();

        ArrayList<Order> transactions = new ArrayList<>(transactionRepository.findAllByUser(user));
        for (Order transaction : transactions){
            products.add(transaction.getProduct());
        }

        return products;
    }

    /**
     * Displays a list of users bought certain product
     * @param id id of the product
     * @return list of users bought product with certain id 
     */
    public ArrayList<User> getAllUsersByProductId(long id) throws Exception{
        Game product = null;
        if (productRepository.existsById(id)){
            product = productRepository.getById(id);
        } else {
            throw new ProductNotFoundException();
        }
        ArrayList<User> users = new ArrayList<>();

        ArrayList<Order> transactions = new ArrayList<>(transactionRepository.findAllByProduct(product));
        for (Order transaction : transactions){
            users.add(transaction.getUser());
        }

        return users;
    }

    public void createTransaction(long userId, long productId) throws Exception{
        User user = null;
        if (userRepository.existsById(userId)){
            user = userRepository.getById(userId);
        } else {
            throw new NotFoundException();
        }
        Game product = null;
        if (productRepository.existsById(productId)){
            product = productRepository.getById(productId);
        } else {
            throw new ProductNotFoundException();
        }
        if (user.getMoneyAmount() < product.getPrice()){
            throw new NotEnoughMoneyToBuyProductException();
        }
        Order transaction = new Order();
        transaction.setUser(user);
        transaction.setProduct(product);
        transactionRepository.save(transaction);

        user.setMoneyAmount(user.getMoneyAmount() - product.getPrice());
        userRepository.save(user);
    }
}
