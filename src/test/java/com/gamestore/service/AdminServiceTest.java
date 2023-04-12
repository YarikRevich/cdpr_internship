package com.gamestore.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.gamestore.dao.UserDAO;
import com.gamestore.dto.AdminCreationRequestDTO;
import com.gamestore.dto.AdminCreationResponseDTO;
import com.gamestore.dto.UserCreationRequestDTO;
import com.gamestore.dto.UserCreationResponseDTO;
import com.gamestore.entity.Admin;
import com.gamestore.entity.User;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = "spring.sql.init.mode=never")
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Test
    public void createShouldWork() {
        UserCreationRequestDTO userCreationRequestDto = new UserCreationRequestDTO();
        userCreationRequestDto.setFirstName("test");
        userCreationRequestDto.setLastName("test");
        userCreationRequestDto.setEmail("test");
        userCreationRequestDto.setPassword("test");

        UserCreationResponseDTO userCreationResponseDto = null;
        try{
            userCreationResponseDto = this.userService.create(userCreationRequestDto);
        } catch (AlreadyExistsException e){
            e.printStackTrace();
        }
        long userId = userCreationResponseDto.getId();
        assertThat(userId).isGreaterThan(0);

        AdminCreationRequestDTO adminCreationRequestDto = new AdminCreationRequestDTO();
        adminCreationRequestDto.setUserId(userId);
        
        AdminCreationResponseDTO adminCreationResponseDto = null;
        try {
            adminCreationResponseDto = this.adminService.create(adminCreationRequestDto);
        } catch (AlreadyExistsException e){
            e.printStackTrace();
        } catch (NotFoundException e){
            e.printStackTrace();
        }
        long adminId = adminCreationResponseDto.getId();
        assertThat(adminId).isGreaterThan(0);
    }

    @Test
    public void createWithoutUserShouldFail(){
        // TODO: implement this
    }

    @Test
    public void getShouldWork(){
        // TODO: implement this
    }

    @Test
    public void getShouldFail(){
       // TODO: implement this
    }

    @Test
    public void getAllShouldWork (){
        assertThat(this.adminService.getAll()).isEmpty();

        UserCreationRequestDTO userCreationRequestDto = new UserCreationRequestDTO();
        userCreationRequestDto.setFirstName("test");
        userCreationRequestDto.setLastName("test");
        userCreationRequestDto.setEmail("test");
        userCreationRequestDto.setPassword("test");

        UserCreationResponseDTO userCreationResponseDto = null;
        try{
            userCreationResponseDto = this.userService.create(userCreationRequestDto);
        } catch (AlreadyExistsException e){
            e.printStackTrace();
        }
        long userId = userCreationResponseDto.getId();
        assertThat(userId).isGreaterThan(0);

        AdminCreationRequestDTO adminCreationRequestDto = new AdminCreationRequestDTO();
        adminCreationRequestDto.setUserId(userId);
        
        AdminCreationResponseDTO adminCreationResponseDto = null;
        try {
            adminCreationResponseDto = this.adminService.create(adminCreationRequestDto);
        } catch (AlreadyExistsException e){
            e.printStackTrace();
        } catch (NotFoundException e){
            e.printStackTrace();
        }
        long adminId = adminCreationResponseDto.getId();
        assertThat(adminId).isGreaterThan(0);

        assertThat(this.adminService.getAll().size()).isEqualTo(1);
    }

    @Test
    public void deleteShouldWork(){
        // TODO: implement this
    }

    @Test
    public void deleteShouldFail(){
       // TODO: implement this
    }
}
