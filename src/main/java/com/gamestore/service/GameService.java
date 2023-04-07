package com.example.practicaltask.service;

import java.util.ArrayList;
import java.util.List;

import com.example.practicaltask.dao.GameDAO;
import com.example.practicaltask.entity.Game;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GameService {
    @Autowired
    private GameDAO gameDao;

    public long create(Game product) throws Exception{
        return this.gameDao.save(product);
    }

    public Game get(long id) throws Exception {
        return this.gameDao.getById(id);
    }

    public List<Game> getAll(){
        return this.gameDao.getAll();
    }

    public void delete(long id) throws Exception{
        return this.gameDao.delete(id);
    }
}
