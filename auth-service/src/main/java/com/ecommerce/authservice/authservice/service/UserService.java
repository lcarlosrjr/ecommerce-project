package com.ecommerce.authservice.authservice.service;

import com.ecommerce.authservice.authservice.model.User;

public interface UserService {

    User save(User user);
    User findByUsername(String username);
    boolean authenticate(String username, String password);
    String generateToken(User user);

}
