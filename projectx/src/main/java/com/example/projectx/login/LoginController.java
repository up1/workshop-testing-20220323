package com.example.projectx.login;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @PostMapping("/signin")
    public UserResponse checkUserAndPassword(@RequestBody LoginRequest loginRequest) {
        // TODO :: Validate request
        // TODO :: Login process
        return new UserResponse(1, loginRequest.getUsername());
    }

}
