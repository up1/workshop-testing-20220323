package com.example.projectx.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LoginControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void success_case_with_code_200() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("somkiat");
        loginRequest.setPassword("xxx");
        UserResponse result = restTemplate.postForObject("/api/auth/signin",
                loginRequest,
                UserResponse.class);
        assertEquals(1, result.getId());
        assertEquals("somkiat", result.getName());
    }
}