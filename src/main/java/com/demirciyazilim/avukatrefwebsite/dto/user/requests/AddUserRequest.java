package com.demirciyazilim.avukatrefwebsite.dto.user.requests;


import com.demirciyazilim.avukatrefwebsite.entity.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String email;
    private String password;
    private List<Role> authorities;
    private String userImagePath;
}

