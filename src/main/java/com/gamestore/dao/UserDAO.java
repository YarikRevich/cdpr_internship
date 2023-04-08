package com.gamestore.dao;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.gamestore.entity.User;
import com.gamestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

/**
 * Dao service which interects with user repository
 */
@Service
public class UserDAO {
    @Autowired
    private UserRepository userRepository;

    public long save(User user){
        User result = userRepository.save(user);
        return result.getId();
    }

    public User getById(long id) throws EntityNotFoundException{
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    public void delete(long id) throws Exception{
        this.userRepository.deleteById(id);
    }
}
