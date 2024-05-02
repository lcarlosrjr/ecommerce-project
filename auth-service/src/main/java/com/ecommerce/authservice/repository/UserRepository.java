package com.ecommerce.authservice.repository;

import com.ecommerce.authservice.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String name);
}
