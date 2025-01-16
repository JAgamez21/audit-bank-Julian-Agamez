package com.example.audit_bank_Julian_Agamez.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditTransactionRequestDTO {

    @NotBlank(message = "Transaction type is mandatory.")
    private String transactionType;

    @NotNull(message = "Initial balance is mandatory.")
    @Min(value = 0, message = "Initial balance must be non-negative.")
    private Double initialBalance;

    @NotNull(message = "Amount is mandatory.")
    @Min(value = 0, message = "Amount must be non-negative.")
    private Double amount;

    @NotBlank(message = "User ID is mandatory.")
    private String userId;

    private LocalDateTime transactionDate = LocalDateTime.now();
}
