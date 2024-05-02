package com.ecommerce.authservice.authservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user_info")
public class UserInfo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

}
