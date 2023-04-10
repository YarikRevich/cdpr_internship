package com.gamestore.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.gamestore.entity.Game;

import org.springframework.stereotype.Component;

@Component
public class GameDAO {
    @Autowired
    private GameRepository gameRepository;

    public long save(Game game) {
        Game result = this.gameRepository.save(game);
        return result.getId();
    }

    public Game getById(long id) throws EntityNotFoundException {
        return this.gameRepository.findById(id);
    }

    public boolean existsById(long id) throws EntityNotFoundException {
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
