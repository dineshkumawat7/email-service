package com.spring.app.controller;

import com.spring.app.model.OtpEmailRequest;
import com.spring.app.payload.ApiResponse;
import com.spring.app.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/email")
@Validated
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send/otp")
    public ResponseEntity<ApiResponse<String>> sendOtpEmail(@Valid @RequestBody OtpEmailRequest emailRequest) {
        emailService.sendRegisterOtpEmail(emailRequest);
        ApiResponse<String> response = new ApiResponse<>();
        response.setTimestamp(LocalDateTime.now());
        response.setSuccess(true);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OTP send successfully to " + emailRequest.getTo());
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
