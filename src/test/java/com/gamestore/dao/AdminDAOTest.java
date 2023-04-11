package com.gamestore.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.gamestore.entity.Admin;
import com.gamestore.entity.User;
import com.gamestore.repository.AdminRepository;
import com.gamestore.repository.UserRepository;

@SpringBootTest
@DataJpaTest
public class AdminDAOTest {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;
    // public long save(Admin admin){
    //     Admin result = this.adminRepository.save(admin);
    //     return result.getId();
    // }

    // public Admin getById(long id) throws EntityNotFoundException{
    //     return this.adminRepository.findById(id);
    // }

    // public boolean existsById(long id) throws EntityNotFoundException{
    //     return this.adminRepository.existsById(id);
    // };

    // public List<Admin> getAll() {
    //     return this.adminRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    // }
    
    // public void delete(long id) {
    //     this.adminRepository.deleteById(id);
    // }

    // public void setUp() throws Exception{
    //     ArrayList<Game> products = productDao.getAllProducts();
    //     for (Game product : products){
    //         productDao.deleteProduct(product.getId());
    //     };
    // }


    @Test
    public void saveShouldWork(){
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setPassword("test");

        User userSaveResult = this.userRepository.save(user);
        assertThat(userSaveResult.getId()).isEqualTo(1);

        Admin admin = new Admin();
        admin.setUser(user);
        
        Admin adminSaveResult = this.adminRepository.save(admin);
        assertThat(adminSaveResult.getId()).isEqualTo(1);
    }

    @Test
    public void getByIdShouldWork(){
        
    }

    @Test
    public void existsByIdShouldWork(){
        
    }

    @Test
    public void getAllShouldWork(){
        
    }

    @Test
    public void deleteShouldWork(){
        
    }
}
