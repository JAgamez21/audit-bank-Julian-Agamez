package com.example.audit_bank_Julian_Agamez.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "audit_transactions")
public class AuditTransaction {

    @Id
    private String id;
    private String transactionType;
    private double initialBalance;
    private double transactionAmount;
    private double finalBalance;
    private String userId;
    private LocalDateTime transactionDate;
    private String withdrawalType; // Opcional para retiros
}