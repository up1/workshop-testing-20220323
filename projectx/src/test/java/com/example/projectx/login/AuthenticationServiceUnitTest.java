package com.example.projectx.login;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceUnitTest {

    @InjectMocks
    private AuthenticationService service;

    @Mock
    private AdGateway adGateway;

    @Mock
    private UserRepository userRepository;

    @Test
    void signin_with_success() {
        when(adGateway.isUserExisted("somkiat")).thenReturn(true);

        User somkiat = new User();
        somkiat.setId(1);
        somkiat.setFirstName("somkiat");
        somkiat.setLastName("pui");
        when(userRepository.get("somkiat", "xxx")).thenReturn(somkiat);

        UserResponse result = service.signin("somkiat", "xxx");
        assertEquals(1, result.getId());
        assertEquals("somkiat", result.getName());
    }
}