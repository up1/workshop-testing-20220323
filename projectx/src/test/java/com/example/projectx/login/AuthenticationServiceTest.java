package com.example.projectx.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthenticationServiceTest {

    @Autowired
    private AuthenticationService authenticationService;

    @MockBean
    private AdGateway adGateway;

    @MockBean
    private UserRepository userRepository;

    @Test
    void signin_success() {
        when(adGateway.isUserExisted("somkiat")).thenReturn(true);

        User somkiat = new User();
        somkiat.setId(1);
        somkiat.setFirstName("somkiat");
        somkiat.setLastName("pui");
        when(userRepository.get("somkiat", "xxx")).thenReturn(somkiat);

        UserResponse result = authenticationService.signin("somkiat", "xxx");
        assertEquals(1, result.getId());
        assertEquals("somkiat", result.getName());
    }
}