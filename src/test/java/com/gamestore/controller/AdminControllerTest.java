package com.gamestore.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.gamestore.dto.AdminCreationRequestDTO;
import com.gamestore.dto.AdminCreationResponseDTO;
import com.gamestore.dto.AdminRetrievalRequestDTO;
import com.gamestore.dto.AdminRetrievalResponseDTO;
import com.gamestore.dto.UserCreationRequestDTO;
import com.gamestore.dto.UserCreationResponseDTO;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;
import com.gamestore.service.AdminService;
import com.gamestore.service.UserService;

import org.apache.http.client.utils.URIBuilder;

@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT, 
    properties = "spring.sql.init.mode=never")
public class AdminControllerTest {
    @Value(value="${local.server.port}")
	private int port;

    @Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    URIBuilder getURIBuilder() {
        return new URIBuilder()
        .setScheme("http")
        .setHost("localhost")
        .setPort(port);
    }

    @Test
	public void createShouldWork() throws Exception {
        UserCreationRequestDTO userCreationRequestDto = new UserCreationRequestDTO();
        userCreationRequestDto.setFirstName("test");
        userCreationRequestDto.setLastName("test");
        userCreationRequestDto.setEmail("1@gmail.com");
        userCreationRequestDto.setPassword("test");

        UserCreationResponseDTO userCreationResponseDto = null;
        try{
            userCreationResponseDto = this.userService.create(userCreationRequestDto);
        } catch (AlreadyExistsException e){
            e.printStackTrace();
        }
        long userId = userCreationResponseDto.getId();
        assertThat(userId).isGreaterThan(0);

        URIBuilder builder = this.getURIBuilder();
        builder.setPath("/v1/admin");
        String url = builder.build().toString();

        AdminCreationRequestDTO adminCreationRequestDto = new AdminCreationRequestDTO();
        adminCreationRequestDto.setUserId(userId);

        ResponseEntity<AdminCreationResponseDTO> result = this.restTemplate.postForEntity(url, adminCreationRequestDto, AdminCreationResponseDTO.class);

        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(result.getBody().getId()).isGreaterThan(0);

        AdminRetrievalRequestDTO adminRetrievalRequestDto = new AdminRetrievalRequestDTO();
        adminRetrievalRequestDto.setId(result.getBody().getId());

        assertThat(this.adminService.get(adminRetrievalRequestDto).getUser().getId()).isEqualTo(userId);
	}

    @Test
	public void getShouldWork() throws Exception {
        UserCreationRequestDTO userCreationRequestDto = new UserCreationRequestDTO();
        userCreationRequestDto.setFirstName("test");
        userCreationRequestDto.setLastName("test");
        userCreationRequestDto.setEmail("2@gmail.com");
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

        URIBuilder builder = this.getURIBuilder();
        builder.setPath("/v1/admin");
        builder.addParameter("id", Long.toString(adminId));
        String url = builder.build().toString();

        ResponseEntity<AdminRetrievalResponseDTO> result = this.restTemplate.getForEntity(url, AdminRetrievalResponseDTO.class);

        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(result.getBody().getId()).isNotNull();
	}

    @Test
	public void getAllShouldWork() throws Exception {
        UserCreationRequestDTO userCreationRequestDto = new UserCreationRequestDTO();
        userCreationRequestDto.setFirstName("test");
        userCreationRequestDto.setLastName("test");
        userCreationRequestDto.setEmail("3@gmail.com");
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

        URIBuilder builder = this.getURIBuilder();
        builder.setPath("/v1/admins");
        String url = builder.build().toString();

        ResponseEntity<AdminRetrievalResponseDTO[]> result = this.restTemplate.getForEntity(url, AdminRetrievalResponseDTO[].class);

        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(result.getBody()).isNotEmpty();
	}

    @Test
	public void deleteShouldWork() throws Exception {
        UserCreationRequestDTO userCreationRequestDto = new UserCreationRequestDTO();
        userCreationRequestDto.setFirstName("test");
        userCreationRequestDto.setLastName("test");
        userCreationRequestDto.setEmail("4@gmail.com");
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

        URIBuilder builder = this.getURIBuilder();
        builder.setPath("/v1/admin");
        builder.addParameter("id", Long.toString(adminId));
        String url = builder.build().toString();

        ResponseEntity<Void> result = this.restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

        assertThat(result.getStatusCodeValue()).isEqualTo(200);

        AdminRetrievalRequestDTO adminRetrievalRequestDto = new AdminRetrievalRequestDTO();
        adminRetrievalRequestDto.setId(adminId);

        assertThatExceptionOfType(NotFoundException.class)
        .isThrownBy(() -> { this.adminService.get(adminRetrievalRequestDto); });
	}
}
