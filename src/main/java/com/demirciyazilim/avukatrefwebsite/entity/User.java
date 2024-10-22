package com.demirciyazilim.avukatrefwebsite.entity;

import com.demirciyazilim.avukatrefwebsite.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role; // Could be "ADMIN" or "USER", or we can create an Enum

    @Column(nullable = false)
    private boolean active = true;

}