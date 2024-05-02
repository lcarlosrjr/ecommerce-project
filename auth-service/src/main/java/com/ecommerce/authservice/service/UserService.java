package com.ecommerce.authservice.service;

import com.ecommerce.authservice.model.UserInfo;

public interface UserService {

    UserInfo save(UserInfo user);
    UserInfo findByUsername(String username);
    boolean authenticate(String username, String password);
    String generateToken(UserInfo user);

}
