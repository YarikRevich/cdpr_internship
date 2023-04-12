package com.gamestore.dao;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.gamestore.entity.Genre;
import com.gamestore.repository.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * Service layer for Genre entities.
 * 
 * @author YarikRevich
 */
@Component
public class GenreDAO {
    @Autowired
    private GenreRepository genreRepository;

    /**
     * Saves a Genre entity to the database.
     * 
     * @param genre The Genre entity to be saved.
     * @return The ID of the saved Genre entity.
     */
    public long save(Genre genre){
        Genre result = this.genreRepository.save(genre);
        return result.getId();
    }

    /**
     * Retrieves a Genre entity by its ID.
     * 
     * @param id The ID of the Genre entity to retrieve.
     * @return The Genre entity with the specified ID.
     * @throws EntityNotFoundException If the Genre entity is not found.
     */
    public Genre getById(long id) throws EntityNotFoundException{
        return this.genreRepository.findById(id);
    }

    /**
     * Checks if a Genre entity exists in the database by its ID.
     * 
     * @param id The ID of the Genre entity to check.
     * @return True if the Genre entity exists, false otherwise.
     * @throws EntityNotFoundException If the Genre entity is not found.
     */
    public boolean existsById(long id) throws EntityNotFoundException{
        return this.genreRepository.existsById(id);
    };

    /**
     * Checks if a Genre entity exists in the database by its name.
     * 
     * @param name The name of the Genre entity to check.
     * @return True if the Genre entity exists, false otherwise.
     * @throws EntityNotFoundException If the Genre entity is not found.
     */
    public boolean existsByName(String name) throws EntityNotFoundException{
        return this.genreRepository.existsByName(name);
    };

    /**
     * Retrieves a list of all Genre entities from the database.
     * 
     * @return A list of all Genre entities, sorted by ID in ascending order.
     */
    public List<Genre> getAll() {
        return this.genreRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    /**
     * Deletes a Genre entity from the database by its ID.
     * 
     * @param id The ID of the Genre entity to delete.
     */
    public void delete(long id) {
        this.genreRepository.deleteById(id);
    }
}
