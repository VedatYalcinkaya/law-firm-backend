package com.demirciyazilim.avukatrefwebsite.dto.article.responses;

import lombok.Data;

@Data
public class GetAllArticleResponse {
    private int id;
    private String title;
    private String content;
    private String author;
    private String category;
    private boolean isPublished;
    private String imagePath;
}
