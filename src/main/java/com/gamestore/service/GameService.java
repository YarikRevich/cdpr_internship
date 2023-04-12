package com.gamestore.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gamestore.dao.GameDAO;
import com.gamestore.dto.GameCreationRequestDTO;
import com.gamestore.dto.GameCreationResponseDTO;
import com.gamestore.dto.GameDeleteRequestDTO;
import com.gamestore.dto.GameRetrievalRequestDTO;
import com.gamestore.dto.GameRetrievalResponseDTO;
import com.gamestore.dto.GameUpdateRequestDTO;
import com.gamestore.dto.GenreRetrievalResponseDTO;
import com.gamestore.entity.Game;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GameService {
    @Autowired
    private GameDAO gameDao;

    public GameCreationResponseDTO create(GameCreationRequestDTO gameCreationRequestDto) throws AlreadyExistsException {
        if (!this.gameDao.existsByName(gameCreationRequestDto.getName())){
            Game game = new Game();
            game.setName(gameCreationRequestDto.getName());
            game.setGenres(gameCreationRequestDto.getGenres());
            game.setPrice(gameCreationRequestDto.getPrice());
            game.setAvailableQuantity(gameCreationRequestDto.getAvailableQuantity());

            long id = this.gameDao.save(game);

            GameCreationResponseDTO gameCreationResponseDto = new GameCreationResponseDTO();
            gameCreationResponseDto.setId(id);

            return gameCreationResponseDto;
        } else {
            throw new AlreadyExistsException("Game with the given name already exists");
        }
    }

    public GameRetrievalResponseDTO get(GameRetrievalRequestDTO gameRetrievalRequestDto) throws NotFoundException {
        System.out.println(gameRetrievalRequestDto);
        return null;
        // if (this.gameDao.existsById(id)){
        //     return this.gameDao.getById(id);
        // } else {
        //     throw new NotFoundException("Game with the given id does not exist");
        // }
    }

    public List<GameRetrievalResponseDTO> getAll(){
        List<Game> games = this.gameDao.getAll();

        return games.stream()
            .map(game -> new GameRetrievalResponseDTO(
                game.getId(), 
                game.getName(), 
                game.getGenres().stream().map(genre -> new GenreRetrievalResponseDTO(
                    genre.getId(), 
                    genre.getName())).collect(Collectors.toList()), 
                game.getPrice(), 
                game.getAvailableQuantity()))
            .collect(Collectors.toList());
    }

    public void update(GameUpdateRequestDTO gameUpdateRequestDto) throws NotFoundException {
        if (this.gameDao.existsByName(gameUpdateRequestDto.getName())){
            Game game = new Game();
            game.setName(gameUpdateRequestDto.getName());
            game.setGenres(gameUpdateRequestDto.getGenres());
            game.setPrice(gameUpdateRequestDto.getPrice());
            game.setAvailableQuantity(gameUpdateRequestDto.getAvailableQuantity());

            this.gameDao.save(game);
        } else {
            throw new NotFoundException("Game with the given properties does not exist");
        }
    }

    public void delete(GameDeleteRequestDTO gameDeleteRequestDto)throws NotFoundException {
        if (this.gameDao.existsById(gameDeleteRequestDto.getId())){
            this.gameDao.delete(gameDeleteRequestDto.getId());
        } else {
            throw new NotFoundException("Game with the given id does not exist");
        }   
    } 
}
