package com.demirciyazilim.avukatrefwebsite.dto.email.requests;

import lombok.Data;

@Data
public class EmailRequest {
    private String name;
    private String email;
    private String phone;
    private String message;
}
