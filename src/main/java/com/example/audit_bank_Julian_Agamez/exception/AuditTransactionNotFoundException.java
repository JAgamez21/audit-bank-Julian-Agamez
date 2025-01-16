package com.example.audit_bank_Julian_Agamez.exception;

public class AuditTransactionNotFoundException extends RuntimeException {
    public AuditTransactionNotFoundException(String message) {
        super(message);
    }
}
