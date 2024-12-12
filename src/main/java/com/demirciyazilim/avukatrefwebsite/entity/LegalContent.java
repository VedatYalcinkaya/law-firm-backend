package com.demirciyazilim.avukatrefwebsite.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "legal_contents")
public class LegalContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title; // Ana başlık

    @Column(nullable = false)
    private String subtitle; // Alt başlık

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; // İçerik

    @Column(nullable = true)
    private String imageUrl; // Resim URL'i

}
