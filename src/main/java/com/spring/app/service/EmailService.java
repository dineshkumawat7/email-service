package com.spring.app.service;

import com.spring.app.model.OtpEmailRequest;

public interface EmailService {
    void sendRegisterOtpEmail(OtpEmailRequest request);

    void sendNotificationEmail(String to, String subject, String body);
}
