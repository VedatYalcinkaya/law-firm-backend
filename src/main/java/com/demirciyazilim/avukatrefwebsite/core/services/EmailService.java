package com.demirciyazilim.avukatrefwebsite.core.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String name, String email, String phone, String message) {
        try {
            String emailContent = "<h2>cindemirhukuk.com'dan bi mesajınız var.</h2>" +
                    "<p><strong>Ad Soyad:</strong> " + name + "</p>" +
                    "<p><strong>Email:</strong> " + email + "</p>" +
                    "<p><strong>Telefon:</strong> " + phone + "</p>" +
                    "<p><strong>Mesaj:</strong> " + message + "</p>";

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

// E-posta içeriğini HTML olarak ayarlayın
            helper.setText(emailContent, true);

// Gönderen ve alıcı adreslerini ayarlayın
            helper.setFrom("noreply@demirciyazilim.com");
            helper.setTo("av.cagatay@cindemirhukuk.com");

// Konuyu ayarlayın
            helper.setSubject("cindemirhukuk.com'dan bir mesajınız var.");

// E-posta gönderimi
            mailSender.send(mimeMessage);
        } catch (MailException e) {
            throw new RuntimeException("E-posta gönderimi başarısız oldu: " + e.getMessage(), e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
