package com.demirciyazilim.avukatrefwebsite.service.abstracts;

import com.demirciyazilim.avukatrefwebsite.dto.auth.requests.AuthRequest;
import com.demirciyazilim.avukatrefwebsite.dto.auth.requests.RegisterUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.auth.response.AuthResponse;

public interface AuthenticationService {

    AuthResponse register(RegisterUserRequest request);


    AuthResponse authenticate(AuthRequest request);
}
