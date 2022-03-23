package com.example.projectx.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LoginControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private AdGateway adGateway;

    @MockBean
    private UserRepository userRepository;

    @Test
    void success_case_with_code_200() {
        when(adGateway.isUserExisted("somkiat")).thenReturn(true);

        User somkiat = new User();
        somkiat.setId(1);
        somkiat.setFirstName("somkiat");
        somkiat.setLastName("pui");
        when(userRepository.get("somkiat", "xxx")).thenReturn(somkiat);

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