package com.example.audit_bank_Julian_Agamez.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class WithdrawalRequestDTO {

    @NotNull(message = "El identificador del usuario no puede ser nulo.")
    private String userId;

    @Min(value = 1, message = "El monto a retirar debe ser mayor a 0.")
    private double amount;

    @NotNull(message = "El tipo de retiro no puede ser nulo.")
    private String withdrawalType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }
}
