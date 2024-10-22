package com.demirciyazilim.avukatrefwebsite.dto.contact.responses;

import lombok.Data;

@Data
public class GetContactByIdResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
