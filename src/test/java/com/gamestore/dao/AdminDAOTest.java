package com.gamestore.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.gamestore.entity.Admin;
import com.gamestore.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = "spring.sql.init.mode=never")
public class AdminDAOTest {
    @Autowired
    private AdminDAO adminDao;

    @Autowired
    private UserDAO userDao;

    @Test
    public void saveShouldWork(){
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
    }

    @Test
    public void saveWithoutUserShouldFail(){
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
    public void getByIdShouldWork(){
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
    public void getByIdShouldFail(){
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
    public void existsByIdShouldWork(){
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
    public void existsByIdShouldFail(){
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

        assertThat(this.adminDao.existsById(adminId + 1)).isFalse();
    }

    @Test
    public void getAllShouldWork(){
        assertThat(this.userDao.getAll()).isEmpty();
        assertThat(this.adminDao.getAll()).isEmpty();

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

        assertThat(this.adminDao.getAll().size()).isEqualTo(1);
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
