package com.example.audit_bank_Julian_Agamez.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditTransactionResponseDTO {

    private String id;
    private String transactionType;
    private double transactionAmount;
    private LocalDateTime transactionDate;
    private double initialBalance;
    private double finalBalance;
    private String withdrawalType;
}