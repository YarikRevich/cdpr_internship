package com.example.practicaltask.repository;

import org.springframework.stereotype.Repository;
import com.example.practicaltask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(long id);
    public boolean existsById(int id);
}
