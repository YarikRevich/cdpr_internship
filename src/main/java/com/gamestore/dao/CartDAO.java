package com.gamestore.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.gamestore.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.gamestore.entity.Cart;
import com.gamestore.entity.User;

import org.springframework.stereotype.Component;

/**
 * Service layer for Cart entities.
 * 
 * @author YarikRevich
 */
@Component
public class CartDAO {
    @Autowired
    private CartRepository cartRepository;

    /**
     * Saves a Cart entity to the database.
     * 
     * @param order The Cart entity to be saved.
     * @return The ID of the saved Cart entity.
     */
    public long save(Cart cart) {
        Cart result = this.cartRepository.save(cart);
        return result.getId();
    }

    /**
     * Retrieves a Cart entity by its ID.
     * 
     * @param id The ID of the Cart entity to retrieve.
     * @return The Cart entity with the specified ID.
     * @throws EntityNotFoundException If the Cart entity is not found.
     */
    public Cart getById(long id) throws EntityNotFoundException {
        return this.cartRepository.findById(id);
    }

    /**
     * Checks if a Cart entity exists in the database by its ID.
     * 
     * @param id The ID of the Cart entity to check.
     * @return True if the Cart entity exists, false otherwise.
     * @throws EntityNotFoundException If the Cart entity is not found.
     */
    public boolean existsById(long id) throws EntityNotFoundException {
        return this.cartRepository.existsById(id);
    };

    /**
     * Retrieves a Cart entity by the attached Cart.
     * 
     * @param user The attached User of the Cart entity to retrieve.
     * @return The Cart entity with the attached Cart.
     * @throws EntityNotFoundException If the Cart entity is not found.
     */
    public Cart getByUser(User user) throws EntityNotFoundException {
        return this.cartRepository.findByUser(user);
    }

    /**
     * Checks if a Cart entity exists in the database by its name.
     * 
     * @param user The User entity to check.
     * @return True if the Cart entity exists, false otherwise.
     * @throws EntityNotFoundException If the Cart entity is not found.
     */
    public boolean existsByUser(User user) throws EntityNotFoundException {
        return this.cartRepository.existsByUser(user);
    };

    /**
     * Retrieves a list of all Cart entities from the database.
     * 
     * @return A list of all Cart entities, sorted by ID in ascending order.
     */
    public List<Cart> getAll() {
        return this.cartRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /**
     * Deletes a Cart entity from the database by its ID.
     * 
     * @param id The ID of the Cart entity to delete.
     * @throws EntityNotFoundException If the Cart entity is not found.
     */
    public void delete(long id) throws EntityNotFoundException {
        this.cartRepository.deleteById(id);
    }
}
