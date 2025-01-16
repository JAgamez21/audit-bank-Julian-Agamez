package com.example.audit_bank_Julian_Agamez.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorDTO {
    private String field;
    private String message;
}
