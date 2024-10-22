package com.demirciyazilim.avukatrefwebsite.dto.user.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserRequest {

    @Positive(message = "Id pozitif olmalıdır!")
    @NotNull(message = "Id boş bırakılamaz!")
    private Long id;

    @NotBlank(message = "Kullanıcı adı zorunludur")
    @Size(max = 50, message = "Kullanıcı adı 50 karakterden uzun olamaz")
    private String username;

    @NotBlank(message = "Şifre zorunludur")
    @Size(min = 8, message = "Şifre en az 8 karakter olmalıdır")
    private String password;

    @NotBlank(message = "Rol zorunludur")
    private String role;
}
