package com.demirciyazilim.avukatrefwebsite.entity;

import com.demirciyazilim.avukatrefwebsite.entity.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
@Entity
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="created_date" ,nullable = true)
    private LocalDate createdDate;

    @Column(name="updated_date",nullable = true)
    private LocalDate updatedDate;

    @PrePersist
    private void beforeAdd() {
        createdDate = LocalDate.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        updatedDate = LocalDate.now();
    }

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @JoinTable(name="roles", joinColumns = @JoinColumn(name="user_id"))
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private List<Role> authorities;

    @Column(name = "user_image_path")
    private String userImagePath;


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
