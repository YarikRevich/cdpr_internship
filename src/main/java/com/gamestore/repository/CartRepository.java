package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.Cart;
import com.gamestore.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    public Cart findById(long id);
    public boolean existsById(long id);

    public Cart findByUser(User user);
    public boolean existsByUser(User user);
}