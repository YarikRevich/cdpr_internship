package com.gamestore.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import com.gamestore.entity.Game;
import com.gamestore.entity.User;
// import com.gamestore.practicaltask.dao.ProductDAO;
// import com.gamestore.practicaltask.util.dataloader.DataLoader;
import com.gamestore.dao.UserDAO;
import com.gamestore.dao.OrderDAO;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Unit tests for TransactionDao
 */
// @Import({DataLoader.class, ProductDAO.class, UserDAO.class, OrderDAO.class})
@DataJpaTest
public class OrderDAOTests {
    // @Autowired
    // private OrderDAO transactionDao;

    // @Test
    // public void testCreateTransaction(){
    //     try{
    //         transactionDao.createTransaction(1, 1);
    //     } catch (Exception e){
    //         e.printStackTrace();
    //     }
    // }

    // @Test
    // public void testGetAllProductsByUserId(){
    //     try{
    //         transactionDao.createTransaction(1, 2);
    //     } catch (Exception e){
    //         e.printStackTrace();
    //     }


    //     ArrayList<Game> products = null;
    //     try{
    //         products = transactionDao.getAllProductsByUserId(1);
    //     } catch (Exception e){
    //         e.printStackTrace();
    //     }
    //     assertEquals(products.size(), 1);
    //     assertEquals(products.get(0).getId(), 2);
    // }

    // @Test
    // public void testGetAllUsersByProductId(){
    //     try{
    //         transactionDao.createTransaction(1, 2);
    //     } catch (Exception e){
    //         e.printStackTrace();
    //     }

    //     ArrayList<User> users = null;
    //     try{
    //         users = transactionDao.getAllUsersByProductId(2);
    //     } catch (Exception e){
    //         e.printStackTrace();
    //     }
    //     assertEquals(users.size(), 1);
    //     assertEquals(users.get(0).getId(), 1);
    // }
}
