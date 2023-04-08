package com.gamestore.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

import com.gamestore.entity.User;
import com.gamestore.practicaltask.dao.ProductDAO;
import com.gamestore.practicaltask.util.dataloader.DataLoader;
import com.gamestore.dao.UserDAO;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Unit tests for UserDao
 */
@Import({DataLoader.class, ProductDAO.class, UserDAO.class})
@DataJpaTest
public class UserDaoTests {
    @Autowired
    private UserDAO userDao;

    @BeforeEach
    public void setUp() throws Exception{
        ArrayList<User> users = userDao.getAllUsers();
        for (User user : users){
            userDao.deleteUser(user.getId());
        };
    }

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setFirstName("Boris");
        user.setLastName("Johnson");
        user.setMoneyAmount(1000);

        userDao.createUser(user);

        User userReceived = null;
        try {
            userReceived = userDao.getUserById(user.getId());
        } catch (Exception e){
        }
        assertNotNull(userReceived);
        assertEquals(userReceived.getId(), user.getId());
        assertEquals(userReceived.getFirstName(), user.getFirstName());
        assertEquals(userReceived.getLastName(), user.getLastName());
        assertEquals(userReceived.getMoneyAmount(), user.getMoneyAmount());
    }

    @Test
    public void testDeleteUser(){
        User user = new User();
        user.setFirstName("Boris");
        user.setLastName("Johnson");
        user.setMoneyAmount(1000);

        userDao.createUser(user);

        try{
            userDao.deleteUser(user.getId());
        } catch (Exception e){
            e.printStackTrace();
        }

        assertEquals(userDao.getAllUsers().size(), 0);
    }

    @Test
    public void testGetUserById(){
        User user = new User();
        user.setFirstName("Boris");
        user.setLastName("Johnson");
        user.setMoneyAmount(1000);

        userDao.createUser(user);

        try {
            userDao.getUserById(user.getId());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllUsers(){
        User user1 = new User();
        user1.setFirstName("Boris");
        user1.setLastName("Johnson");
        user1.setMoneyAmount(1000);

        User user2 = new User();
        user2.setFirstName("Volodymyr");
        user2.setLastName("Zelenskyi");
        user2.setMoneyAmount(100);

        userDao.createUser(user1);
        userDao.createUser(user2);

        ArrayList<User> users = userDao.getAllUsers();
        assertEquals(users.size(), 2);
        assertEquals(users.get(0), user1);
        assertEquals(users.get(1), user2);
    }

    @Test
    public void testGetUserMoneyAmount(){
        User user = new User();
        user.setFirstName("Boris");
        user.setLastName("Johnson");
        user.setMoneyAmount(1000);

        userDao.createUser(user);

        try{
            assertEquals(userDao.getUserMoneyAmount(user.getId()), user.getMoneyAmount());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSetUserMoneyAmount(){
        User user = new User();
        user.setFirstName("Boris");
        user.setLastName("Johnson");
        user.setMoneyAmount(1000);

        userDao.createUser(user);

        try{
            assertEquals(userDao.getUserMoneyAmount(user.getId()), user.getMoneyAmount());
        } catch (Exception e){
            e.printStackTrace();
        }

        final int newMoneyAmount = 1100;
        try{
            userDao.setUserMoneyAmount(user.getId(), newMoneyAmount);
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            assertEquals(userDao.getUserMoneyAmount(user.getId()), newMoneyAmount);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
