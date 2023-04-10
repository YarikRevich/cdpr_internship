package com.gamestore.dao;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.gamestore.entity.Genre;
import com.gamestore.repository.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

@Service
public class GenreDAO {
    @Autowired
    private GenreRepository genreRepository;

    public long save(Genre genre){
        Genre result = this.genreRepository.save(genre);
        return result.getId();
    }

    public Genre getById(long id) throws EntityNotFoundException{
        return this.genreRepository.findById(id);
    }

    public boolean existsById(long id) throws EntityNotFoundException{
        return this.genreRepository.existsById(id);
    };

    public boolean existsByName(String name) throws EntityNotFoundException{
        return this.genreRepository.existsByName(name);
    };

    public List<Genre> getAll() {
        return this.genreRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    public void delete(long id) {
        this.genreRepository.deleteById(id);
    }
}
