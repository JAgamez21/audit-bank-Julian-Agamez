package com.example.audit_bank_Julian_Agamez.exception;

public class ValidationException extends RuntimeException {
    private final String details;

    public ValidationException(String message, String details) {
        super(message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
