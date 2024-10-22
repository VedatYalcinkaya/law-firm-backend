package com.demirciyazilim.avukatrefwebsite.dto.contact.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddContactRequest {
    @NotBlank(message = "İsim zorunludur")
    @Size(max = 100, message = "İsim 100 karakterden uzun olamaz")
    private String name;

    @NotBlank(message = "E-posta zorunludur")
    @Email(message = "Geçerli bir e-posta adresi giriniz")
    private String email;

    @Size(max = 15, message = "Telefon numarası 15 karakterden uzun olamaz")
    private String phoneNumber;
}
