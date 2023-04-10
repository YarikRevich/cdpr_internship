package com.gamestore.service;

import java.nio.channels.AlreadyBoundException;
import java.util.List;

import com.gamestore.dao.AdminDAO;
import com.gamestore.dao.UserDAO;
import com.gamestore.dto.AdminCreationDTO;
import com.gamestore.entity.Admin;
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

    public long create(AdminCreationDTO adminCreationDto) throws AlreadyExistsException {
        if (this.userDao.existsById(adminCreationDto.getUserId())){
            Admin admin = new Admin();
            admin.setUser(this.userDao.getById(adminCreationDto.getUserId()));
            
            return this.adminDao.save(admin);
        } else {
            throw new AlreadyExistsException("Admin with the given id already exists");
        }
    }

    public Admin get(long id) throws NotFoundException {
        if (this.adminDao.existsById(id)){
            return this.adminDao.getById(id);
        } else {
            throw new NotFoundException("Admin with the given id does not exist");
        }
    }

    public List<Admin> getAll(){
        return this.adminDao.getAll();
    }

    public void delete(long id) throws NotFoundException {
        if (this.adminDao.existsById(id)){
            this.adminDao.delete(id);
        } else {
            throw new NotFoundException("Admin with the given id does not exist");
        }  
    } 
}
