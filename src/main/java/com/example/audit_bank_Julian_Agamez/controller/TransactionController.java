package com.example.audit_bank_Julian_Agamez.controller;

import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionRequestDTO;
import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionResponseDTO;
import com.example.audit_bank_Julian_Agamez.handler.TransactionHandler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transactions")
@Validated
public class TransactionController {

    private final TransactionHandler transactionHandler;

    public TransactionController(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }

    @PostMapping("/deposit")
    public Mono<AuditTransactionResponseDTO> createDeposit(@RequestBody @Validated AuditTransactionRequestDTO depositRequest) {
        return transactionHandler.handleDeposit(depositRequest);
    }

    @PostMapping("/withdrawal")
    public Mono<AuditTransactionResponseDTO> createWithdrawal(@RequestBody @Validated AuditTransactionRequestDTO withdrawalRequest) {
        return transactionHandler.handleWithdrawal(withdrawalRequest);
    }

    @GetMapping("/{userId}")
    public Flux<AuditTransactionResponseDTO> getTransactionsByUser(@PathVariable String userId) {
        return transactionHandler.getTransactionsByUser(userId);
    }
}