package com.example.audit_bank_Julian_Agamez.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bank_accounts")
public class BankAccount {

    @Id
    private String id;
    private String accountNumber;
    private String userId; // Reference to the User
    private double balance;
    private boolean isBlocked;
}
