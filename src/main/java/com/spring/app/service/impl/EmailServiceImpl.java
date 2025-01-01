package com.spring.app.service.impl;

import com.spring.app.model.OtpEmailRequest;
import com.spring.app.service.EmailService;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    private void sendMail(String to, String subject, String body) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(new InternetAddress(to));
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(mimeMessage);
            log.info("mail sending success to: {}", to);
        } catch (MessagingException e) {
            log.error("error occurred when sending email: {}", e.getMessage());
        }
    }


    @Override
    public void sendRegisterOtpEmail(OtpEmailRequest request) {
        Context context = new Context();
        context.setVariable("user", request.getTo());
        context.setVariable("otp", request.getOtp());
        String htmlContent = templateEngine.process("otp-page.html", context);
        sendMail(request.getTo(), request.getSubject(), htmlContent);
    }

    @Override
    public void sendNotificationEmail(String to, String subject, String body) {

    }
}
