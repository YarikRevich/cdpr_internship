package com.gamestore.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gamestore.dao.UserDAO;
import com.gamestore.dto.UserCreationRequestDTO;
import com.gamestore.dto.UserCreationResponseDTO;
import com.gamestore.dto.UserRetrievalResponseDTO;
import com.gamestore.dto.UserUpdateRequestDTO;
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

    public UserCreationResponseDTO create(UserCreationRequestDTO userCreationRequestDto) throws AlreadyExistsException {
        if (!this.userDao.existsByEmail(userCreationRequestDto.getEmail())){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        
            User user = new User();
            user.setFirstName(userCreationRequestDto.getFirstName());
            user.setLastName(userCreationRequestDto.getLastName());
            user.setEmail(userCreationRequestDto.getEmail());
            user.setPassword(passwordEncoder.encode(userCreationRequestDto.getPassword()));

            long id = this.userDao.save(user);

            UserCreationResponseDTO userCreationResponseDto = new UserCreationResponseDTO();
            userCreationResponseDto.setId(id);
            
            return userCreationResponseDto;
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

    public List<UserRetrievalResponseDTO> getAll(){
        List<User> users = this.userDao.getAll();

        return users.stream()
            .map(user -> new UserRetrievalResponseDTO(
                user.getId(), 
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()))
            .collect(Collectors.toList());
    }

    public void update(UserUpdateRequestDTO userUpdateRequestDto) throws AlreadyExistsException {
        if (this.userDao.existsByEmail(userUpdateRequestDto.getEmail())){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        
            User user = new User();
            user.setFirstName(userUpdateRequestDto.getFirstName());
            user.setLastName(userUpdateRequestDto.getLastName());
            user.setEmail(userUpdateRequestDto.getEmail());
            user.setPassword(passwordEncoder.encode(userUpdateRequestDto.getPassword()));
        
            this.userDao.save(user);
        } else {
            throw new AlreadyExistsException("User with the given properties does not exists");
        }
    }

    public void delete(long id) throws NotFoundException {
        if (this.userDao.existsById(id)){
            this.userDao.delete(id);
        } else {
            throw new NotFoundException("User with the given id does not exist");
        }
    } 
}
