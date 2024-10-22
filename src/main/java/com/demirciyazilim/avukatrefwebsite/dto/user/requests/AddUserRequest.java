package com.demirciyazilim.avukatrefwebsite.dto.user.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class AddUserRequest {
    @NotBlank(message = "Kullanıcı adı zorunludur")
    @Size(max = 50, message = "Kullanıcı adı 50 karakterden uzun olamaz")
    private String username;

    @NotBlank(message = "Şifre zorunludur")
    @Size(min = 8, message = "Şifre en az 8 karakter olmalıdır")
    private String password;

    @NotBlank(message = "Rol zorunludur")
    private String role;
}
