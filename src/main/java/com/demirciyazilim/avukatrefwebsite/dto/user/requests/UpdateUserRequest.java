package com.demirciyazilim.avukatrefwebsite.dto.user.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserRequest {

    @Positive(message = "Please enter a valid Id.")
    private int id;
    private String email;
    private String password;
    private String userImagePath;
}
