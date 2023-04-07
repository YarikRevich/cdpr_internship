package com.example.practicaltask.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.practicaltask.dao.UserDao;
import com.example.practicaltask.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Services, which are used in "users" scope
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * Creates certain user
     * @param user the model used to create the user
     */
    public void create(User user){
        userDao.createUser(user);
    }

    /**
     * Lists all the existing users
     * @return list of all the existing users
     */
    public ArrayList<User> get(){
        return userDao.getAllUsers();
    }

    /**
     * Deletes certain user
     * @param id the id of the user to be deleted
     */
    public void delete(long id) throws Exception{
        userDao.deleteUser(id);
    } 
}
