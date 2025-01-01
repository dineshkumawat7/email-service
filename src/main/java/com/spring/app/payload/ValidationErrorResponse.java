package com.spring.app.payload;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorResponse {
    private LocalDateTime timestamp;
    private boolean success;
    private int status;
    private String message;
    private List<SimpleFieldError> details;

    public ValidationErrorResponse() {
    }

    public ValidationErrorResponse(LocalDateTime timestamp, boolean success, int status, String message, List<SimpleFieldError> details) {
        this.timestamp = timestamp;
        this.success = success;
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SimpleFieldError> getDetails() {
        return details;
    }

    public void setDetails(List<SimpleFieldError> details) {
        this.details = details;
    }

    public static class SimpleFieldError {
        private String field;
        private String defaultMessage;
        private Object rejectedValue;

        public SimpleFieldError() {
        }

        public SimpleFieldError(String field, String defaultMessage, Object rejectedValue) {
            this.field = field;
            this.defaultMessage = defaultMessage;
            this.rejectedValue = rejectedValue;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getDefaultMessage() {
            return defaultMessage;
        }

        public void setDefaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
        }

        public Object getRejectedValue() {
            return rejectedValue;
        }

        public void setRejectedValue(Object rejectedValue) {
            this.rejectedValue = rejectedValue;
        }
    }
}
