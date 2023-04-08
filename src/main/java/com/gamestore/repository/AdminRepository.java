package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findById(long id);
    public boolean existsById(long id);
}