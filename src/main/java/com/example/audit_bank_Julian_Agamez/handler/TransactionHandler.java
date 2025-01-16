package com.example.audit_bank_Julian_Agamez.handler;

import com.example.audit_bank_Julian_Agamez.dto.DepositRequestDTO;
import com.example.audit_bank_Julian_Agamez.dto.WithdrawalRequestDTO;
import com.example.audit_bank_Julian_Agamez.model.Transaction;
import com.example.audit_bank_Julian_Agamez.service.TransactionService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TransactionHandler {

    private final TransactionService transactionService;

    public TransactionHandler(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Mono<ServerResponse> handleDeposit(ServerRequest request) {
        return request.bodyToMono(DepositRequestDTO.class)
                .flatMap(transactionService::processDeposit)
                .flatMap(transaction -> ServerResponse.ok().bodyValue(transaction))
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> handleWithdrawal(ServerRequest request) {
        return request.bodyToMono(WithdrawalRequestDTO.class)
                .flatMap(transactionService::processWithdrawal)
                .flatMap(transaction -> ServerResponse.ok().bodyValue(transaction))
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> getTransactionsByUserId(ServerRequest request) {
        String userId = request.pathVariable("userId");
        return ServerResponse.ok()
                .body(transactionService.getTransactionsByUserId(userId), Transaction.class)
                .onErrorResume(e -> ServerResponse.notFound().build());
    }
}
