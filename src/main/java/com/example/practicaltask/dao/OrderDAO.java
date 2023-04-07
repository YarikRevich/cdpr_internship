package com.example.practicaltask.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.example.practicaltask.repository.UserRepository;
import com.example.practicaltask.repository.GameRepository;
import com.example.practicaltask.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.practicaltask.util.exception.NotEnoughMoneyToBuyProductException;
import com.example.practicaltask.util.exception.ProductNotFoundException;
import com.example.practicaltask.util.exception.UserNotFoundException;

import com.example.practicaltask.entity.User;
import com.example.practicaltask.entity.Game;
import com.example.practicaltask.entity.Order;

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
            throw new UserNotFoundException();
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
            throw new UserNotFoundException();
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
