package com.example.audit_bank_Julian_Agamez.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;
    private String userId;
    private String type; // "Deposit" or "Withdrawal"
    private double initialBalance;
    private double amount;
    private double finalBalance;
    private LocalDateTime timestamp;

    public Transaction(String userId, String type, double initialBalance, double amount, double finalBalance) {
        this.userId = userId;
        this.type = type;
        this.initialBalance = initialBalance;
        this.amount = amount;
        this.finalBalance = finalBalance;
        this.timestamp = LocalDateTime.now();
    }
}
