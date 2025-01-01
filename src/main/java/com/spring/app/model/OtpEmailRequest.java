package com.spring.app.model;

import jakarta.validation.constraints.*;

import java.io.Serializable;

public class OtpEmailRequest implements Serializable {
    @Pattern(
            regexp = "^(?!\\.)[a-zA-Z0-9._%+-]{1,64}(?<!\\.)@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,63}$",
            message = "Invalid email format"
    )
    private String to;

    @NotBlank(message = "Subject is required")
    private String subject;

    @Pattern(regexp = "^\\d{6}$", message = "OTP is invalid!")
    private String otp;

    public OtpEmailRequest() {
    }

    public OtpEmailRequest(String to, String subject, String otp) {
        this.to = to;
        this.subject = subject;
        this.otp = otp;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
