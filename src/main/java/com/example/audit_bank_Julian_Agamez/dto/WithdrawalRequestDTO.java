package com.example.audit_bank_Julian_Agamez.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalRequestDTO {

    @NotBlank(message = "User ID is mandatory.")
    private String userId;

    @NotNull(message = "Amount is mandatory.")
    @Min(value = 0, message = "Amount must be non-negative.")
    private Double amount;

    @NotBlank(message = "Account number is mandatory.")
    private String accountNumber;

    @NotBlank(message = "Withdrawal type is mandatory.")
    private String withdrawalType; // For example, ATM or Teller
}
