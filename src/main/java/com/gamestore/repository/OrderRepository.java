package com.gamestore.repository;

import java.util.List;

import com.gamestore.entity.Order;
import com.gamestore.entity.User;
import com.gamestore.entity.Game;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findAllByUser(User user);
    public List<Order> findAllByProduct(Game product);
}

