package com.demirciyazilim.avukatrefwebsite.dto.contact.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateContactRequest {

    @Positive(message = "Id pozitif olmalıdır!")
    @NotNull(message = "Id boş bırakılamaz!")
    private Long id;

    @NotBlank(message = "İsim zorunludur")
    @Size(max = 100, message = "İsim 100 karakterden uzun olamaz")
    private String name;

    @NotBlank(message = "E-posta zorunludur")
    @Email(message = "Geçerli bir e-posta adresi giriniz")
    private String email;

    @Size(max = 15, message = "Telefon numarası 15 karakterden uzun olamaz")
    private String phoneNumber;
}
