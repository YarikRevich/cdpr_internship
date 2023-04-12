package com.gamestore.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.gamestore.repository.GameRepository;
import com.gamestore.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.gamestore.entity.Cart;
import com.gamestore.entity.Order;
import com.gamestore.entity.Order;

import org.springframework.stereotype.Component;

/**
 * Service layer for Order entities.
 * 
 * @author YarikRevich
 */
@Component
public class OrderDAO {
    @Autowired
    private OrderRepository orderRepository;

    /**
     * Saves a Order entity to the database.
     * 
     * @param order The Order entity to be saved.
     * @return The ID of the saved Order entity.
     */
    public long save(Order order) {
        Order result = this.orderRepository.save(order);
        return result.getId();
    }

    /**
     * Retrieves a Order entity by its ID.
     * 
     * @param id The ID of the Order entity to retrieve.
     * @return The Order entity with the specified ID.
     * @throws EntityNotFoundException If the Order entity is not found.
     */
    public Order getById(long id) throws EntityNotFoundException {
        return this.orderRepository.findById(id);
    }

    /**
     * Checks if a Order entity exists in the database by its ID.
     * 
     * @param id The ID of the Order entity to check.
     * @return True if the Order entity exists, false otherwise.
     * @throws EntityNotFoundException If the Order entity is not found.
     */
    public boolean existsById(long id) throws EntityNotFoundException {
        return this.orderRepository.existsById(id);
    };

    /**
     * Retrieves a Order entity by the attached Cart.
     * 
     * @param id The attached Cart of the Order entity to retrieve.
     * @return The Order entity with the attached Cart.
     * @throws EntityNotFoundException If the Order entity is not found.
     */
    public Order getByCart(Cart cart) throws EntityNotFoundException {
        return this.orderRepository.findByCart(cart);
    }

    /**
     * Checks if a Order entity exists in the database by its name.
     * 
     * @param cart The Order entity to check.
     * @return True if the Order entity exists, false otherwise.
     * @throws EntityNotFoundException If the Order entity is not found.
     */
    public boolean existsByCart(Cart cart) throws EntityNotFoundException {
        return this.orderRepository.existsByCart(cart);
    };

    /**
     * Retrieves a list of all Order entities from the database.
     * 
     * @return A list of all Order entities, sorted by ID in ascending order.
     */
    public List<Order> getAll() {
        return this.orderRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /**
     * Deletes a Order entity from the database by its ID.
     * 
     * @param id The ID of the Order entity to delete.
     * @throws EntityNotFoundException If the Order entity is not found.
     */
    public void delete(long id) throws EntityNotFoundException {
        this.orderRepository.deleteById(id);
    }
}
