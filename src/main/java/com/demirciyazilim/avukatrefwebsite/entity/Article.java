package com.demirciyazilim.avukatrefwebsite.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Table(name = "articles")
@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(nullable = false)
    private String author;

    private String category;

    @Column(nullable = false)
    private String imagePath;

    private boolean isPublished;


    @PrePersist
    protected void onCreate() {
        this.createdDate = new Date();
    }
}