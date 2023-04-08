package com.gamestore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gamestore.dao.UserDAO;
import com.gamestore.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public long create(User user) throws Exception {
        return this.userDao.save(user);
    }

    public User get(long id) throws Exception {
        return this.userDao.getById(id);
    }

    public List<User> getAll(){
        return this.userDao.getAll();
    }

    public void delete(long id) throws Exception {
        this.userDao.delete(id);
    } 
}
