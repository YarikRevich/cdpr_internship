package com.gamestore.dao;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.gamestore.entity.Admin;
import com.gamestore.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

@Service
public class AdminDAO {
    @Autowired
    private AdminRepository adminRepository;

    public long save(Admin admin){
        Admin result = this.adminRepository.save(admin);
        return result.getId();
    }

    public Admin getById(long id) throws EntityNotFoundException{
        return this.adminRepository.findById(id);
    }

    public boolean existsById(long id) throws EntityNotFoundException{
        return this.adminRepository.existsById(id);
    };

    public List<Admin> getAll() {
        return this.adminRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    public void delete(long id) {
        this.adminRepository.deleteById(id);
    }
}
