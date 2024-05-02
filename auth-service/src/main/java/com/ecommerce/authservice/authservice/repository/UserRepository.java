package com.ecommerce.authservice.authservice.repository;

import com.ecommerce.authservice.authservice.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String name);
}
