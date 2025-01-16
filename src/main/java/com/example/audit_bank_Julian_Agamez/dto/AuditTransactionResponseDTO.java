package com.example.audit_bank_Julian_Agamez.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuditTransactionResponseDTO {

    private String auditId;
    private String transactionType;
    private Double initialBalance;
    private Double amount;
    private Double finalBalance;
    private String userId;
    private String message;
}
