package com.example.audit_bank_Julian_Agamez.util;

import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionRequestDTO;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

public class ValidationUtil {

    public static void validateRequest(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessages = bindingResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Validation failed: " + errorMessages);
        }
    }

    public static boolean validateTransactionRequest(AuditTransactionRequestDTO requestDTO) {
        return requestDTO.getAmount() > 0 && requestDTO.getInitialBalance() >= 0;
    }
}