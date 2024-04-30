package com.ecommerce.authservice.authservice.repository;

import com.ecommerce.authservice.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
