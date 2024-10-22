package com.demirciyazilim.avukatrefwebsite.dto.article.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DeleteArticleRequest {
    @Positive(message = "Id must be a positive number!")
    @NotNull(message = "Id can not be empty!")
    private Long id;
}
