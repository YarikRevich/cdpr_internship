package com.gamestore.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.gamestore.entity.Game;

import org.springframework.stereotype.Component;

/**
 * Service layer for Game entities.
 * 
 * @author YarikRevich
 */
@Component
public class GameDAO {
    @Autowired
    private GameRepository gameRepository;

    /**
     * Saves a Game entity to the database.
     * 
     * @param game The Game entity to be saved.
     * @return The ID of the saved Game entity.
     */
    public long save(Game game) {
        Game result = this.gameRepository.save(game);
        return result.getId();
    }

    /**
     * Retrieves a Game entity by its ID.
     * 
     * @param id The ID of the Game entity to retrieve.
     * @return The Game entity with the specified ID.
     * @throws EntityNotFoundException If the Game entity is not found.
     */
    public Game getById(long id) throws EntityNotFoundException {
        return this.gameRepository.findById(id);
    }

    /**
     * Checks if a Game entity exists in the database by its ID.
     * 
     * @param id The ID of the Game entity to check.
     * @return True if the Game entity exists, false otherwise.
     * @throws EntityNotFoundException If the Game entity is not found.
     */
    public boolean existsById(long id) throws EntityNotFoundException {
        return this.gameRepository.existsById(id);
    };

    /**
     * Checks if a Game entity exists in the database by its name.
     * 
     * @param name The name of the Game entity to check.
     * @return True if the Game entity exists, false otherwise.
     * @throws EntityNotFoundException If the Game entity is not found.
     */
    public boolean existsByName(String name) throws EntityNotFoundException {
        return this.gameRepository.existsByName(name);
    };

    /**
     * Retrieves a list of all Game entities from the database.
     * 
     * @return A list of all Game entities, sorted by ID in ascending order.
     */
    public List<Game> getAll() {
        return this.gameRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

     /**
     * Deletes a Game entity from the database by its ID.
     * 
     * @param id The ID of the Game entity to delete.
     * @throws EntityNotFoundException If the Game entity is not found.
     */
    public void delete(long id) throws EntityNotFoundException {
        this.gameRepository.deleteById(id);
    }
}
