package com.gamestore.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.gamestore.dao.UserDAO;
import com.gamestore.entity.Admin;
import com.gamestore.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = "spring.sql.init.mode=never")
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Test
    public void createShouldWork(){
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setPassword("test");

        long userId = this.adminService.create(user);
        assertThat(userId).isGreaterThan(0);

        Admin admin = new Admin();
        admin.setUser(user);
        
        long adminId = this.adminDao.save(admin);
        assertThat(adminId).isGreaterThan(0);
    }

    @Test
    public void createWithoutUserShouldFail(){
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setPassword("test");

        Admin admin = new Admin();
        admin.setUser(user);
        
        long adminId = this.adminDao.save(admin);
        assertThat(adminId).isGreaterThan(0);
    }

    @Test
    public void getShouldWork(){
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setPassword("test");

        long userId = this.userDao.save(user);
        assertThat(userId).isGreaterThan(0);

        Admin admin = new Admin();
        admin.setUser(user);
        
        long adminId = this.adminDao.save(admin);
        assertThat(userId).isGreaterThan(0);

        admin = this.adminDao.getById(adminId);
        assertThat(admin.getUser()).isEqualTo(user);
    }

    @Test
    public void getShouldFail(){
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setPassword("test");

        long userId = this.userDao.save(user);
        assertThat(userId).isGreaterThan(0);

        Admin admin = new Admin();
        admin.setUser(user);
        
        long adminId = this.adminDao.save(admin);
        assertThat(userId).isGreaterThan(0);

        admin = this.adminDao.getById(adminId + 1);
        assertThat(admin).isNull();
    }

    @Test
    public void getAllShouldWork (){
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setPassword("test");

        long userId = this.userDao.save(user);
        assertThat(userId).isGreaterThan(0);

        Admin admin = new Admin();
        admin.setUser(user);
        
        long adminId = this.adminDao.save(admin);
        assertThat(adminId).isGreaterThan(0);

        assertThat(this.adminDao.existsById(adminId)).isTrue();
    }

    @Test
    public void deleteShouldWork(){
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setPassword("test");

        long userId = this.userDao.save(user);
        assertThat(userId).isGreaterThan(0);

        Admin admin = new Admin();
        admin.setUser(user);
        
        long adminId = this.adminDao.save(admin);
        assertThat(adminId).isGreaterThan(0);

        this.adminDao.delete(adminId);

        assertThat(this.adminDao.existsById(adminId)).isFalse();
    }

    @Test
    public void deleteShouldFail(){
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setPassword("test");

        long userId = this.userDao.save(user);
        assertThat(userId).isGreaterThan(0);

        Admin admin = new Admin();
        admin.setUser(user);
        
        long adminId = this.adminDao.save(admin);
        assertThat(adminId).isGreaterThan(0);

        try {
            this.adminDao.delete(adminId+1);
        } catch (EmptyResultDataAccessException ex) {
            assertThat(this.adminDao.existsById(adminId)).isTrue();
        }
    }
}
