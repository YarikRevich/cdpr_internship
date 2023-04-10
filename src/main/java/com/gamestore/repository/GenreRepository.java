package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    public Genre findById(long id);
    public boolean existsById(long id);

    public boolean existsByName(String name);
}