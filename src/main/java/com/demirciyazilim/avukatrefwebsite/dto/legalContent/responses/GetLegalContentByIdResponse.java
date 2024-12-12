package com.demirciyazilim.avukatrefwebsite.dto.legalContent.responses;

import lombok.Data;

@Data
public class GetLegalContentByIdResponse {
    private Long id;
    private String title; // Ana başlık
    private String subtitle; // Alt başlık
    private String content; // İçerik
    private String imageUrl; // Resim URL'i
}
