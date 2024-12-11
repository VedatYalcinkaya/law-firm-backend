package com.demirciyazilim.avukatrefwebsite.controller;
import com.demirciyazilim.avukatrefwebsite.core.services.EmailService;
import com.demirciyazilim.avukatrefwebsite.dto.email.requests.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(
                emailRequest.getName(),
                emailRequest.getEmail(),
                emailRequest.getPhone(),
                emailRequest.getMessage()
        );
        return ResponseEntity.ok("E-posta başarıyla gönderildi!");
    }
}
