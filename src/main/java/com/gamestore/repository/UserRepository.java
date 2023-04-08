package com.gamestore.repository;

import org.springframework.stereotype.Repository;
import com.gamestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(long id);
    public boolean existsById(long id);

    public User findByEmail(String email);
    public boolean existsByEmail(String email);
}
