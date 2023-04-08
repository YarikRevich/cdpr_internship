package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.CartItem;
import com.gamestore.entity.Game;
import com.gamestore.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
    public List<CartItem> findAllById(long id);
    public boolean existsById(long id);
    
    public List<CartItem> findAllByUser(User user);
    public boolean existsByUser(User user);
    
    public List<CartItem> findAllByGame(Game game);
    public boolean existsByGame(Game game);
}