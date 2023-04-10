package com.gamestore.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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

    public long save(Game game) {
        Game result = this.gameRepository.save(game);
        return result.getId();
    }

    public Game getById(long id) throws EntityNotFoundException{
        return this.gameRepository.findById(id);
    }

    public boolean existsById(long id) throws EntityNotFoundException{
        return this.gameRepository.existsById(id);
    };

    public boolean existsByName(String name) throws EntityNotFoundException {
        return this.gameRepository.existsByName(name);
    };

    public List<Game> getAll() {
        return this.gameRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void delete(long id) throws EntityNotFoundException {
        this.gameRepository.deleteById(id);
    }
}
