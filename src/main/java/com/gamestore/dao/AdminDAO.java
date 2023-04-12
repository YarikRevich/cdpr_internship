package com.gamestore.dao;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.gamestore.entity.Admin;
import com.gamestore.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Service layer for Admin entities.
 * 
 * @author YarikRevich
 */
@Component
public class AdminDAO {
    @Autowired
    private AdminRepository adminRepository;

    /**
     * Saves an Admin entity to the database.
     * 
     * @param admin The Admin entity to be saved.
     * @return The ID of the saved Admin entity.
     */
    public long save(Admin admin){
        Admin result = this.adminRepository.save(admin);
        return result.getId();
    }

    /**
     * Retrieves an Admin entity by its ID.
     * 
     * @param id The ID of the Admin entity to retrieve.
     * @return The Admin entity with the specified ID.
     * @throws EntityNotFoundException If the Admin entity is not found.
     */
    public Admin getById(long id) throws EntityNotFoundException{
        return this.adminRepository.findById(id);
    }

    /**
     * Checks if an Admin entity exists in the database by its ID.
     * 
     * @param id The ID of the Admin entity to check.
     * @return True if the Admin entity exists, false otherwise.
     * @throws EntityNotFoundException If the Admin entity is not found.
     */
    public boolean existsById(long id) throws EntityNotFoundException{
        return this.adminRepository.existsById(id);
    };

    /**
     * Retrieves a list of all Admin entities from the database.
     * 
     * @return A list of all Admin entities, sorted by ID in ascending order.
     */
    public List<Admin> getAll() {
        return this.adminRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    /**
     * Deletes an Admin entity from the database by its ID.
     * 
     * @param id The ID of the Admin entity to delete.
     */
    public void delete(long id) {
        this.adminRepository.deleteById(id);
    }
}
