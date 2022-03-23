package com.example.projectx.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AdGateway adGateway;

    @Autowired
    private UserRepository userRepository;

    public UserResponse signin(String username, String password) {
        // 1. Check username from AD server
        boolean found = adGateway.isUserExisted(username);
        if(!found) { // Fail fast
            // TODO
        }
        // 2. Get user profile from database table=user
        User user = userRepository.get(username, password);
        if(user == null) { // Fail fast
            // TODO
        }
        // 3. Convert from model to response
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getFirstName());
        // 4. Return response
        return response;
    }

}
