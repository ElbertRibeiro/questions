package com.tomath.user;

import com.tomath.core.user.UserDTO;
import com.tomath.core.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserResoucesTest {
    @Autowired private TestRestTemplate testRestTemplate;
    @Autowired private UserService service;

    @Test void insertUsersTest(){
        UserDTO dtos = new UserDTO();
        dtos.setNameUser("teste teste teste");
        dtos.setTypeUser(1);
        dtos.setEmail("teste@teste.com");
        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(dtos);
        ResponseEntity<String> response =
                testRestTemplate.exchange("/users/create", HttpMethod.POST, httpEntity, String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        service.deleteUser(response.getBody());
    }
}
