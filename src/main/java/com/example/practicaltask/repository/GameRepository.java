package com.example.practicaltask.repository;

import org.springframework.stereotype.Repository;
import com.example.practicaltask.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public Game findById(long id);
    public boolean existsById(long id);
}