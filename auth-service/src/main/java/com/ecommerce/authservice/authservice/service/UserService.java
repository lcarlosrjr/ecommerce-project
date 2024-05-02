package com.ecommerce.authservice.authservice.service;

import com.ecommerce.authservice.authservice.model.UserInfo;

public interface UserService {

    UserInfo save(UserInfo user);
    UserInfo findByUsername(String username);
    boolean authenticate(String username, String password);
    String generateToken(UserInfo user);

}
