package com.example.audit_bank_Julian_Agamez.util;

import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionRequestDTO;
import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionResponseDTO;
import com.example.audit_bank_Julian_Agamez.model.AuditTransaction;

public class MapperUtil {

    public static AuditTransaction toAuditTransaction(AuditTransactionRequestDTO requestDTO) {
        return AuditTransaction.builder()
                .transactionType(requestDTO.getTransactionType())
                .initialBalance(requestDTO.getInitialBalance())
                .transactionAmount(requestDTO.getAmount())
                .userId(requestDTO.getUserId())
                .transactionDate(requestDTO.getTransactionDate())
                .build();
    }

    public static AuditTransactionResponseDTO toAuditTransactionResponseDTO(AuditTransaction transaction) {
        return AuditTransactionResponseDTO.builder()
                .id(transaction.getId())
                .transactionType(transaction.getTransactionType())
                .transactionAmount(transaction.getTransactionAmount())
                .transactionDate(transaction.getTransactionDate())
                .initialBalance(transaction.getInitialBalance())
                .finalBalance(transaction.getFinalBalance())
                .withdrawalType(transaction.getWithdrawalType())
                .build();
    }
}
