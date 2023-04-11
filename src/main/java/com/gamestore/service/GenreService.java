package com.gamestore.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gamestore.dao.GenreDAO;
import com.gamestore.dto.GenreCreationRequestDTO;
import com.gamestore.dto.GenreRetrievalResponseDTO;
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

    public List<GenreRetrievalResponseDTO> getAll(){
        List<Genre> genres = this.genreDao.getAll();
        
        return genres.stream()
            .map(genre -> new GenreRetrievalResponseDTO(
                genre.getId(), 
                genre.getName()))
            .collect(Collectors.toList());
    }

    public void delete(long id) throws NotFoundException {
        if (this.genreDao.existsById(id)){
            this.genreDao.delete(id);
        } else {
            throw new NotFoundException("Genre with the given id does not exist");
        }  
    } 
}
