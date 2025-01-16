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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "audit_transactions")
public class AuditTransaction {

    @Id
    private String id;

    private String transactionType;

    private Double initialBalance;

    private Double amount;

    private Double finalBalance;

    private String userId;

    private LocalDateTime transactionDate;
}
