package com.example.practicaltask.service;

import java.util.ArrayList;
import com.example.practicaltask.dao.OrderDAO;
import com.example.practicaltask.dao.UserDAO;
import com.example.practicaltask.dao.ProductDAO;

import com.example.practicaltask.entity.Game;
import com.example.practicaltask.entity.User;
import com.example.practicaltask.entity.Order;
import com.example.practicaltask.entity.dto.BuyProductWrapper;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Services, which are used in "transactions" scope
 */
@Service
public class OrderService {
    @Autowired
    private OrderDAO transactionDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private ProductDAO productDao;
    
    public ArrayList<Game> getAllProductsByUserId(long id) throws Exception {
        return transactionDao.getAllProductsByUserId(id);
    }

    public ArrayList<User> getAllUsersByProductId(long id) throws Exception {
        return transactionDao.getAllUsersByProductId(id);  
    }

    /**
     * Creates buyProduct transaction and decreases money amount of the user
     * @param userId id of the user
     * @param productId id of the product
     */
    public void buyProduct(BuyProductWrapper buyProductWrapper) throws Exception{
        transactionDao.createTransaction(buyProductWrapper.getUserId(), buyProductWrapper.getProductId());
        int userMoneyAmount = userDao.getUserMoneyAmount(buyProductWrapper.getUserId());
        int productPrice = productDao.getProductPrice(buyProductWrapper.getProductId());
        userDao.setUserMoneyAmount(buyProductWrapper.getUserId(), userMoneyAmount-productPrice);
    }
}
