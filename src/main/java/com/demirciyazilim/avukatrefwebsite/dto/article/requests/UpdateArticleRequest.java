package com.demirciyazilim.avukatrefwebsite.dto.article.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateArticleRequest {

    @Positive(message = "Id pozitif olmalıdır!")
    @NotNull(message = "Id boş bırakılamaz!")
    private Long id;

    @NotNull(message = "Başlık boş bırakılamaz")
    @Size(min = 5, max = 100)
    private String title;

    @NotNull(message = "makale en az 10 karakter içermelidir")
    @Size(min = 10)
    private String content;

    private String author;

    private String category;

    private boolean isPublished;

    private String imagePath;
}
