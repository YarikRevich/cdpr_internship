package com.example.practicaltask.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.practicaltask.repository.UserRepository;
import com.example.practicaltask.repository.GameRepository;
import com.example.practicaltask.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

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
public class GameDAO {
    @Autowired
    private GameRepository gameRepository;

    // @Autowired
    // private UserRepository userRepository;

    // @Autowired
    // private OrderRepository transactionRepository;

    public long save(Game game) throws IllegalArgumentException {
        if (!gameRepository.existsByName(game.getName())){
            Game result = gameRepository.save(game);
            return result.getId();
        }
        //TODO: return exception otherwise
        return 0
    }

    public List<Game> getAll() throws IllegalArgumentException {
        return gameRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    // public ArrayList<Game> create(long id) throws Exception{
    //     User user = null;
    //     if (userRepository.existsById(id)){
    //         user = userRepository.getReferenceById(id);
    //     } else {
    //         throw new UserNotFoundException();
    //     }
    //     ArrayList<Game> products = new ArrayList<>();

    //     ArrayList<Order> transactions = new ArrayList<>(transactionRepository.findAllByUser(user));
    //     for (Order transaction : transactions){
    //         products.add(transaction.getProduct());
    //     }

    //     return products;
    // }

    // /**
    //  * Displays a list of users bought certain product
    //  * @param id id of the product
    //  * @return list of users bought product with certain id 
    //  */
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
