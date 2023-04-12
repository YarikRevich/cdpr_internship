package com.gamestore.repository;

import com.gamestore.entity.Order;
import com.gamestore.entity.Cart;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public Order findById(long id);
    public boolean existsById(long id);

    public Order findByCart(Cart cart);
    public boolean existsByCart(Cart cart);
}

