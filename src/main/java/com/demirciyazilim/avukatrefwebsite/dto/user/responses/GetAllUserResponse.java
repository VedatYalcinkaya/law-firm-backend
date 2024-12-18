package com.demirciyazilim.avukatrefwebsite.dto.user.responses;

import com.demirciyazilim.avukatrefwebsite.entity.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class GetAllUserResponse {

    private int id;
    private String email;
    private String password;
    private List<Role> authorities;
    private String userImagePath;
}
