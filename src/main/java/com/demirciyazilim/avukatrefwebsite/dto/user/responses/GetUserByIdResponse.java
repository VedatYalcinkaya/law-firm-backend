package com.demirciyazilim.avukatrefwebsite.dto.user.responses;

import lombok.Data;

@Data
public class GetUserByIdResponse {
    private Long id;
    private String username;
    private String password;
    private String role;
}
