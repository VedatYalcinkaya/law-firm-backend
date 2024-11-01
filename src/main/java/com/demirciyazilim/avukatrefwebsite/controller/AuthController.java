package com.demirciyazilim.avukatrefwebsite.controller;


import com.demirciyazilim.avukatrefwebsite.dto.auth.requests.AuthRequest;
import com.demirciyazilim.avukatrefwebsite.dto.auth.requests.RegisterUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.auth.response.AuthResponse;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
//DENEME

    private final AuthenticationService service;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> customerRegister(
            @RequestBody RegisterUserRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));

    }
}
