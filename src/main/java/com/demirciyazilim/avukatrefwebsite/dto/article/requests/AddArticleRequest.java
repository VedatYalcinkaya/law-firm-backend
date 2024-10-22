package com.demirciyazilim.avukatrefwebsite.dto.article.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddArticleRequest {

    @NotNull
    @Size(min = 5, max = 100)
    private String title;

    @NotNull
    @Size(min = 10)
    private String content;

    @NotNull
    private String author;

    private String category;

    @JsonProperty("isPublished")
    @NotNull
    private boolean isPublished;

    private String imagePath;
}