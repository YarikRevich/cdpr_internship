package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.Game;
import com.gamestore.entity.Genre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public Game findById(long id);
    public boolean existsById(long id);

    public Game findByName(String name);
    public boolean existsByName(String name);
    
    @Query("SELECT * FROM games WHERE genre IN (:genres)")
    public List<Game> findAllByGenres(List<Genre> genres);

    public List<Game> findAllByPriceGreaterThan(int price);
    public List<Game> findAllByPriceLowerThan(int price);

    public List<Game> findAllByAvailableQuantityNotNull(int price);
}