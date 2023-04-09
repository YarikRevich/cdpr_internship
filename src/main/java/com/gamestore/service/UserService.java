package com.gamestore.service;

import java.util.List;

import com.gamestore.dao.UserDAO;
import com.gamestore.dto.UserCreationDTO;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    public long create(UserCreationDTO userCreationDto) throws AlreadyExistsException {
        if (!this.userDao.existsByEmail(userCreationDto.getEmail())){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
            User user = new User();
            user.setFirstName(userCreationDto.getFirstName());
            user.setLastName(userCreationDto.getLastName());
            user.setEmail(userCreationDto.getEmail());
            user.setPassword(passwordEncoder.encode(userCreationDto.getPassword()));
        
            return this.userDao.save(user);
        } else {
            throw new AlreadyExistsException("User with the given email already exists");
        }
    }

    public User get(long id) throws NotFoundException {
        if (this.userDao.existsById(id)){
            return this.userDao.getById(id);
        } else {
            throw new NotFoundException("User with the given id does not exist");
        }
    }

    public List<User> getAll(){
        return this.userDao.getAll();
    }

    public void delete(long id) throws NotFoundException {
        if (this.userDao.existsById(id)){
            this.userDao.delete(id);
        } else {
            throw new NotFoundException("User with the given id does not exist");
        }
        
    } 
}
