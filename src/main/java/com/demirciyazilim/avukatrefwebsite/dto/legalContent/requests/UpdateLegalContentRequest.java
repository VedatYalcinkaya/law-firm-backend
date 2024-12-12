package com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateLegalContentRequest {
    @Positive(message = "Id pozitif olmalıdır!")
    @NotNull(message = "Id boş bırakılamaz!")
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String title; // Ana başlık

    @NotNull
    @Size(min = 3, max = 100)
    private String subtitle; // Alt başlık

    @NotNull
    @Size(min = 10)
    private String content; // İçerik

    private String imageUrl; // Resim URL'i
}