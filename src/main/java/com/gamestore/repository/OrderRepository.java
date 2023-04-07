package com.example.practicaltask.repository;

import java.util.List;

import com.example.practicaltask.entity.Transaction;
import com.example.practicaltask.entity.User;
import com.example.practicaltask.entity.Game;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public List<Transaction> findAllByUser(User user);
    public List<Transaction> findAllByProduct(Game product);
}

