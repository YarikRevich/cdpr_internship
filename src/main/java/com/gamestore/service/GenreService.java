package com.gamestore.service;

import java.util.List;

import com.gamestore.dao.GenreDAO;
import com.gamestore.dto.GenreCreationRequestDTO;
import com.gamestore.entity.Genre;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GenreService {
    @Autowired
    private GenreDAO genreDao;

    public long create(GenreCreationRequestDTO genreCreationDto) throws AlreadyExistsException {
        if (!this.genreDao.existsByName(genreCreationDto.getName())){
            Genre genre = new Genre();
            genre.setName(genreCreationDto.getName());
            
            return this.genreDao.save(genre);
        } else {
            throw new AlreadyExistsException("Genre with the given name already exists");
        }
    }

    public Genre get(long id) throws NotFoundException {
        if (this.genreDao.existsById(id)){
            return this.genreDao.getById(id);
        } else {
            throw new NotFoundException("Genre with the given id does not exist");
        }
    }

    public List<Genre> getAll(){
        return this.genreDao.getAll();
    }

    public void delete(long id) throws NotFoundException {
        if (this.genreDao.existsById(id)){
            this.genreDao.delete(id);
        } else {
            throw new NotFoundException("Genre with the given id does not exist");
        }  
    } 
}
