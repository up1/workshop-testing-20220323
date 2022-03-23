package com.example.projectx.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signin")
    public UserResponse checkUserAndPassword(@RequestBody LoginRequest loginRequest) {
        // TODO :: Validate request
        // TODO :: Login process
        return authenticationService.signin(
                loginRequest.getUsername(), loginRequest.getPassword());
    }

}
