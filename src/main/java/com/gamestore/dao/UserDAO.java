package com.gamestore.dao;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.gamestore.entity.User;
import com.gamestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * Service layer for User entities.
 * 
 * @author YarikRevich
 */
@Component
public class UserDAO {
    @Autowired
    private UserRepository userRepository;

    /**
     * Saves a User entity to the database.
     * 
     * @param user The User entity to be saved.
     * @return The ID of the saved User entity.
     */
    public long save(User user){
        User result = this.userRepository.save(user);
        return result.getId();
    }

    /**
     * Retrieves a User entity by its ID.
     * 
     * @param id The ID of the User entity to retrieve.
     * @return The User entity with the specified ID.
     * @throws EntityNotFoundException If the User entity is not found.
     */
    public User getById(long id) throws EntityNotFoundException{
        return this.userRepository.findById(id);
    }

    /**
     * Checks if a User entity exists in the database by its id.
     * 
     * @param id The id of the User entity to check.
     * @return True if the User entity exists, false otherwise.
     * @throws EntityNotFoundException If the User entity is not found.
     */
    public boolean existsById(long id) throws EntityNotFoundException{
        return this.userRepository.existsById(id);
    };

    /**
     * Retrieves a User entity by its email.
     * 
     * @param email The email of the User entity to retrieve.
     * @return The User entity with the specified email.
     * @throws EntityNotFoundException If the User entity is not found.
     */
    public User getByEmail(String email) throws EntityNotFoundException{
        return this.userRepository.findByEmail(email);
    }

    /**
     * Checks if a User entity exists in the database by its email.
     * 
     * @param email The email of the User entity to check.
     * @return True if the User entity exists, false otherwise.
     * @throws EntityNotFoundException If the User entity is not found.
     */
    public boolean existsByEmail(String email) throws EntityNotFoundException{
        return this.userRepository.existsByEmail(email);
    }

    /**
     * Retrieves a User entity by its password.
     * 
     * @param password The password of the User entity to retrieve.
     * @return The User entity with the specified password.
     * @throws EntityNotFoundException If the User entity is not found.
     */
    public User getByPassword(String password) throws EntityNotFoundException{
        return this.userRepository.findByPassword(password);
    }

    /**
     * Checks if a User entity exists in the database by its password.
     * 
     * @param password The password of the User entity to check.
     * @return True if the User entity exists, false otherwise.
     * @throws EntityNotFoundException If the User entity is not found.
     */
    public boolean existsByPassword(String password) throws EntityNotFoundException{
        return this.userRepository.existsByPassword(password);
    }

    /**
     * Retrieves a list of all User entities from the database.
     * 
     * @return A list of all User entities, sorted by ID in ascending order.
     */
    public List<User> getAll() {
        return this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    /**
     * Deletes a User entity from the database by its ID.
     * 
     * @param id The ID of the User entity to delete.
     * @throws EntityNotFoundException If the User entity is not found.
     */
    public void delete(long id) {
        this.userRepository.deleteById(id);
    }
}
