package com.demirciyazilim.avukatrefwebsite.dto.auth.requests;

import com.demirciyazilim.avukatrefwebsite.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String email;
    private String username;
    private String password;
    private List<Role> authorities;
}