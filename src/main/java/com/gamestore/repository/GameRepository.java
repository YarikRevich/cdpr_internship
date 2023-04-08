package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.Game;
import com.gamestore.entity.Genre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public Game findById(long id);
    public Game findByName(String name);
    public Game findByGenres(List<Genre> genres);

    public boolean existsById(long id);
    public boolean existsByName(String name);
}