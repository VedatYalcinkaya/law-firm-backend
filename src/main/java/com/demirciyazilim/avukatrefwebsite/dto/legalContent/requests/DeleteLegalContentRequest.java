package com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DeleteLegalContentRequest {
    @Positive(message = "Id must be a positive number!")
    @NotNull(message = "Id can not be empty!")
    private Long id;
}
