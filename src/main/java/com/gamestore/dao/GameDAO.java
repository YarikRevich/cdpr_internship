package com.gamestore.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gamestore.repository.UserRepository;
import com.gamestore.repository.GameRepository;
import com.gamestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

// import com.gamestore.util.exception.NotEnoughMoneyToBuyProductException;
// import com.gamestore.util.exception.ProductNotFoundException;
// import com.gamestore.util.exception.UserNotFoundException;

import com.gamestore.entity.User;
import com.gamestore.entity.Game;
import com.gamestore.entity.Order;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class GameDAO {
    @Autowired
    private GameRepository gameRepository;

    public long save(Game game) throws Exception {
        Game result = this.gameRepository.save(game);
        return result.getId();
    }

    public Game getById(long id) throws Exception{
        return this.gameRepository.findById(id);
    }

    public List<Game> getAll() {
        return this.gameRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void delete(long id){
        this.gameRepository.deleteById(id);
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
}
