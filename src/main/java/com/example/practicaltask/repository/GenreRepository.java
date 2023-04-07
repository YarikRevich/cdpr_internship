package com.example.practicaltask.repository;

import org.springframework.stereotype.Repository;
import com.example.practicaltask.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    public Genre findById(long id);
    public boolean existsById(long id);
}