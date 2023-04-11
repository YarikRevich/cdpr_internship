package com.gamestore.service;

import java.util.List;

import com.gamestore.dao.GameDAO;
import com.gamestore.dao.UserDAO;
import com.gamestore.dto.GameCreationRequestDTO;
import com.gamestore.dto.GameCreationResponseDTO;
import com.gamestore.dto.GameRetrievalRequestDTO;
import com.gamestore.dto.UserCreationDTO;
import com.gamestore.entity.Game;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

            return this.gameDao.save(game);
        } else {
            throw new AlreadyExistsException("Game with the given name already exists");
        }
    }

    public Game get(GameRetrievalRequestDTO gameRetrievalRequestDto) throws NotFoundException {
        System.out.println(gameRetrievalRequestDto);
        return null;
        // if (this.gameDao.existsById(id)){
        //     return this.gameDao.getById(id);
        // } else {
        //     throw new NotFoundException("Game with the given id does not exist");
        // }
    }

    public List<Game> getAll(){
        return this.gameDao.getAll();
    }

    public GameCreationResponseDTO create(GameCreationRequestDTO gameCreationRequestDto) throws AlreadyExistsException {
        if (this.gameDao.existsByName(gameCreationRequestDto.getName())){
            Game game = new Game();
            game.setName(gameCreationRequestDto.getName());
            game.setGenres(gameCreationRequestDto.getGenres());
            game.setPrice(gameCreationRequestDto.getPrice());
            game.setAvailableQuantity(gameCreationRequestDto.getAvailableQuantity());

            return this.gameDao.save(game);
        } else {
            throw new AlreadyExistsException("Game with the given name does not exist");
        }
    }

    public void delete(long id) throws NotFoundException {
        if (this.gameDao.existsById(id)){
            this.gameDao.delete(id);
        } else {
            throw new NotFoundException("Game with the given id does not exist");
        }   
    } 
}
