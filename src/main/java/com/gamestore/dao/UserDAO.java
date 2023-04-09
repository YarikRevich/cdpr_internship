package com.gamestore.dao;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.gamestore.entity.User;
import com.gamestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

@Service
public class UserDAO {
    @Autowired
    private UserRepository userRepository;

    public long save(User user){
        User result = this.userRepository.save(user);
        return result.getId();
    }

    public User getById(long id) throws EntityNotFoundException{
        return this.userRepository.findById(id);
    }

    public boolean existsById(long id) throws EntityNotFoundException{
        return this.userRepository.existsById(id);
    };

    public boolean existsByEmail(String email) throws EntityNotFoundException{
        return this.userRepository.existsByEmail(email);
    }

    public List<User> getAll() {
        return this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    public void delete(long id) {
        this.userRepository.deleteById(id);
    }
}
