package com.demirciyazilim.avukatrefwebsite.dto.user.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GetAllUserResponse {

    private Long id;
    private String username;
    private String password;
    private String role;
}
