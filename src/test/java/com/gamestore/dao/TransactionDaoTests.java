package com.example.practicaltask.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import com.example.practicaltask.entity.Product;
import com.example.practicaltask.entity.User;
import com.example.practicaltask.dao.UserDao;
import com.example.practicaltask.dao.ProductDao;
import com.example.practicaltask.dao.TransactionDao;
import com.example.practicaltask.util.dataloader.DataLoader;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Unit tests for TransactionDao
 */
@Import({DataLoader.class, ProductDao.class, UserDao.class, TransactionDao.class})
@DataJpaTest
public class TransactionDaoTests {
    @Autowired
    private TransactionDao transactionDao;

    @Test
    public void testCreateTransaction(){
        try{
            transactionDao.createTransaction(1, 1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllProductsByUserId(){
        try{
            transactionDao.createTransaction(1, 2);
        } catch (Exception e){
            e.printStackTrace();
        }


        ArrayList<Product> products = null;
        try{
            products = transactionDao.getAllProductsByUserId(1);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(products.size(), 1);
        assertEquals(products.get(0).getId(), 2);
    }

    @Test
    public void testGetAllUsersByProductId(){
        try{
            transactionDao.createTransaction(1, 2);
        } catch (Exception e){
            e.printStackTrace();
        }

        ArrayList<User> users = null;
        try{
            users = transactionDao.getAllUsersByProductId(2);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(users.size(), 1);
        assertEquals(users.get(0).getId(), 1);
    }
}
