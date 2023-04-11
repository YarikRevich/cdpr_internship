package com.gamestore.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gamestore.dao.GenreDAO;
import com.gamestore.dto.GenreCreationRequestDTO;
import com.gamestore.dto.GenreCreationResponseDTO;
import com.gamestore.dto.GenreDeleteRequestDTO;
import com.gamestore.dto.GenreRetrievalRequestDTO;
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

    public GenreCreationResponseDTO create(GenreCreationRequestDTO genreCreationDto) throws AlreadyExistsException {
        if (!this.genreDao.existsByName(genreCreationDto.getName())){
            Genre genre = new Genre();
            genre.setName(genreCreationDto.getName());

            long id = this.genreDao.save(genre);

            GenreCreationResponseDTO genreCreationResponseDto = new GenreCreationResponseDTO();
            genreCreationResponseDto.setId(id);
            
            return genreCreationResponseDto;
        } else {
            throw new AlreadyExistsException("Genre with the given name already exists");
        }
    }

    public GenreRetrievalResponseDTO get(GenreRetrievalRequestDTO genreRetrievalRequestDto) throws NotFoundException {
        if (this.genreDao.existsById(genreRetrievalRequestDto.getId())){
            Genre genre = this.genreDao.getById(genreRetrievalRequestDto.getId());

            GenreRetrievalResponseDTO genreRetrievalResponseDto = new GenreRetrievalResponseDTO();
            genre.setId(genre.getId());
            genre.setName(genre.getName());

            return genreRetrievalResponseDto;
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

    public void delete(GenreDeleteRequestDTO genreDeleteRequestDto) throws NotFoundException {
        if (this.genreDao.existsById(genreDeleteRequestDto.getId())){
            this.genreDao.delete(genreDeleteRequestDto.getId());
        } else {
            throw new NotFoundException("Genre with the given id does not exist");
        }  
    } 
}
