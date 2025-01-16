package com.example.audit_bank_Julian_Agamez.service;

import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionRequestDTO;
import com.example.audit_bank_Julian_Agamez.model.AuditTransaction;
import com.example.audit_bank_Julian_Agamez.repository.AuditTransactionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class AuditTransactionService {

    private final AuditTransactionRepository transactionRepository;

    public AuditTransactionService(AuditTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Mono<AuditTransaction> processDeposit(AuditTransactionRequestDTO depositRequest) {
        AuditTransaction transaction = new AuditTransaction();
        transaction.setTransactionType("Deposit");
        transaction.setInitialBalance(depositRequest.getInitialBalance());
        transaction.setTransactionAmount(depositRequest.getAmount());
        transaction.setFinalBalance(depositRequest.getInitialBalance() + depositRequest.getAmount());
        transaction.setUserId(depositRequest.getUserId());
        transaction.setTransactionDate(depositRequest.getTransactionDate());

        return transactionRepository.save(transaction);
    }

    public Mono<AuditTransaction> processWithdrawal(AuditTransactionRequestDTO withdrawalRequest) {
        if (withdrawalRequest.getAmount() > withdrawalRequest.getInitialBalance()) {
            return Mono.error(new IllegalArgumentException("Insufficient funds"));
        }

        AuditTransaction transaction = new AuditTransaction();
        transaction.setTransactionType("Withdrawal");
        transaction.setInitialBalance(withdrawalRequest.getInitialBalance());
        transaction.setTransactionAmount(withdrawalRequest.getAmount());
        transaction.setFinalBalance(withdrawalRequest.getInitialBalance() - withdrawalRequest.getAmount());
        transaction.setUserId(withdrawalRequest.getUserId());
        transaction.setTransactionDate(withdrawalRequest.getTransactionDate());

        return transactionRepository.save(transaction);
    }

    public Flux<AuditTransaction> getTransactionsByUser(String userId) {
        return transactionRepository.findByUserId(userId);
    }
}
