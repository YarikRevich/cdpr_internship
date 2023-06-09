package com.gamestore.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gamestore.dao.AdminDAO;
import com.gamestore.dao.UserDAO;
import com.gamestore.dto.AdminCreationRequestDTO;
import com.gamestore.dto.AdminCreationResponseDTO;
import com.gamestore.dto.AdminDeleteRequestDTO;
import com.gamestore.dto.AdminRetrievalRequestDTO;
import com.gamestore.dto.AdminRetrievalResponseDTO;
import com.gamestore.dto.UserRetrievalResponseDTO;
import com.gamestore.entity.Admin;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdminService {
    @Autowired
    private AdminDAO adminDao;

    @Autowired
    private UserDAO userDao;

    public AdminCreationResponseDTO create(AdminCreationRequestDTO adminCreationDto) throws AlreadyExistsException, NotFoundException {
        if (this.userDao.existsById(adminCreationDto.getUserId())){
            User user = this.userDao.getById(adminCreationDto.getUserId());
            if (!this.adminDao.existsByUser(user)){
                Admin admin = new Admin();
                admin.setUser(this.userDao.getById(adminCreationDto.getUserId()));

                AdminCreationResponseDTO adminCreationResponseDto = new     AdminCreationResponseDTO();

                adminCreationResponseDto.setId(this.adminDao.save(admin));
                
                return adminCreationResponseDto;
            } else {
                throw new AlreadyExistsException("Admin with the given user id already exists");
            }
        } else {
            throw new NotFoundException("User with the given id does not exist");
        }
    }

    public AdminRetrievalResponseDTO get(AdminRetrievalRequestDTO adminRetrievalRequestDto) throws NotFoundException {
        if (this.adminDao.existsById(adminRetrievalRequestDto.getId())){
            Admin admin = this.adminDao.getById(adminRetrievalRequestDto.getId());

            AdminRetrievalResponseDTO adminRetrievalResponseDto = new AdminRetrievalResponseDTO();
            adminRetrievalResponseDto.setId(admin.getId());

            User user = admin.getUser();
            adminRetrievalResponseDto.setUser(new UserRetrievalResponseDTO(
                user.getId(), 
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()));

            return adminRetrievalResponseDto;
        } else {
            throw new NotFoundException("Admin with the given id does not exist");
        }
    }

    public List<AdminRetrievalResponseDTO> getAll(){
        List<Admin> admins = this.adminDao.getAll();

        return admins.stream()
            .map(game -> new AdminRetrievalResponseDTO(
                game.getId(), 
                new UserRetrievalResponseDTO(
                    game.getUser().getId(), 
                    game.getUser().getFirstName(),
                    game.getUser().getLastName(),
                    game.getUser().getEmail(),
                    game.getUser().getPassword())))
            .collect(Collectors.toList());
    }

    public void delete(AdminDeleteRequestDTO adminDeleteRequestDto) throws NotFoundException {
        if (this.adminDao.existsById(adminDeleteRequestDto.getId())){
            this.adminDao.delete(adminDeleteRequestDto.getId());
        } else {
            throw new NotFoundException("Admin with the given id does not exist");
        }  
    } 
}
