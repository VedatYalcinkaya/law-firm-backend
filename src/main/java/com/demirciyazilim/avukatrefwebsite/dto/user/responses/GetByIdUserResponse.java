package com.demirciyazilim.avukatrefwebsite.dto.user.responses;

import com.demirciyazilim.avukatrefwebsite.entity.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class GetByIdUserResponse {
    private int id;
    private String email;
    private String password;
    private List<Role> authorities;
    private String userImagePath;
}
