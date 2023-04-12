package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.Game;
import com.gamestore.entity.Genre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public Game findById(long id);
    public boolean existsById(long id);

    public Game findByName(String name);
    public boolean existsByName(String name);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM games WHERE name = :name AND price < :priceLowerThan AND price > :priceGreaterThan", nativeQuery = true)
    public boolean existsByFilters(@Param("name") String name, @Param("priceLowerThan") int priceLowerThan, @Param("priceGreaterThan") int priceGreaterThan);
    
    public List<Game> findAllByGenresIn(List<Genre> genres);

    public List<Game> findAllByPriceGreaterThan(int price);
    public List<Game> findAllByPriceLessThan(int price);

    public List<Game> findAllByAvailableQuantityIsNotNull();
}