package com.gamestore.service;

import java.nio.channels.AlreadyBoundException;
import java.util.List;
import java.util.stream.Collectors;

import com.gamestore.dao.AdminDAO;
import com.gamestore.dao.UserDAO;
import com.gamestore.dto.AdminCreationRequestDTO;
import com.gamestore.dto.AdminCreationResponseDTO;
import com.gamestore.dto.AdminDeleteRequestDTO;
import com.gamestore.dto.AdminRetrievalRequestDTO;
import com.gamestore.dto.AdminRetrievalResponseDTO;
import com.gamestore.entity.Admin;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdminService {
    @Autowired
    private AdminDAO adminDao;

    @Autowired
    private UserDAO userDao;

    public AdminCreationResponseDTO create(AdminCreationRequestDTO adminCreationDto) throws AlreadyExistsException {
        if (this.userDao.existsById(adminCreationDto.getUserId())){
            Admin admin = new Admin();
            admin.setUser(this.userDao.getById(adminCreationDto.getUserId()));

            AdminCreationResponseDTO adminCreationResponseDto = new AdminCreationResponseDTO();

            adminCreationResponseDto.setId(this.adminDao.save(admin));
            
            return adminCreationResponseDto;
        } else {
            throw new AlreadyExistsException("Admin with the given id already exists");
        }
    }

    public AdminRetrievalResponseDTO get(AdminRetrievalRequestDTO adminRetrievalRequestDto) throws NotFoundException {
        if (this.adminDao.existsById(adminRetrievalRequestDto.getId())){
            Admin admin = this.adminDao.getById(adminRetrievalRequestDto.getId());

            AdminRetrievalResponseDTO adminRetrievalResponseDto = new AdminRetrievalResponseDTO();
            adminRetrievalResponseDto.setId(admin.getId());
            adminRetrievalResponseDto.setUser(admin.getUser());

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
                game.getUser()))
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
