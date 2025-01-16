package com.example.audit_bank_Julian_Agamez.handler;

import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionRequestDTO;
import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionResponseDTO;
import com.example.audit_bank_Julian_Agamez.service.AuditTransactionService;
import com.example.audit_bank_Julian_Agamez.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TransactionHandler {

    private final AuditTransactionService transactionService;

    public TransactionHandler(AuditTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Mono<AuditTransactionResponseDTO> handleDeposit(AuditTransactionRequestDTO depositRequest) {
        return transactionService.processDeposit(depositRequest)
                .map(MapperUtil::toAuditTransactionResponseDTO);
    }

    public Mono<AuditTransactionResponseDTO> handleWithdrawal(AuditTransactionRequestDTO withdrawalRequest) {
        return transactionService.processWithdrawal(withdrawalRequest)
                .map(MapperUtil::toAuditTransactionResponseDTO);
    }

    public Flux<AuditTransactionResponseDTO> getTransactionsByUser(String userId) {
        return transactionService.getTransactionsByUser(userId)
                .map(MapperUtil::toAuditTransactionResponseDTO);
    }
}