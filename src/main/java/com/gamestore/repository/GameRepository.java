package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public Game findById(long id);
    public boolean existsById(long id);
    public boolean existsByName(String name);
}