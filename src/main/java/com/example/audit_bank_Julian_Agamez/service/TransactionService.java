package com.example.audit_bank_Julian_Agamez.service;

import com.example.audit_bank_Julian_Agamez.dto.DepositRequestDTO;
import com.example.audit_bank_Julian_Agamez.dto.WithdrawalRequestDTO;
import com.example.audit_bank_Julian_Agamez.exception.ResourceNotFoundException;
import com.example.audit_bank_Julian_Agamez.model.Transaction;
import com.example.audit_bank_Julian_Agamez.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Mono<Transaction> processDeposit(DepositRequestDTO depositRequest) {
        return Mono.just(depositRequest)
                .flatMap(request -> {
                    if (request.getAmount() <= 0) {
                        return Mono.error(new IllegalArgumentException("El monto debe ser mayor a 0."));
                    }

                    Transaction transaction = new Transaction();
                    transaction.setUserId(request.getUserId());
                    transaction.setInitialBalance(1000.0); // Ejemplo: Simulación de saldo inicial
                    transaction.setFinalBalance(1000.0 + request.getAmount());

                    return transactionRepository.save(transaction);
                });
    }

    public Mono<Transaction> processWithdrawal(WithdrawalRequestDTO withdrawalRequest) {
        return Mono.just(withdrawalRequest)
                .flatMap(request -> {
                    if (request.getAmount() <= 0) {
                        return Mono.error(new IllegalArgumentException("El monto debe ser mayor a 0."));
                    }

                    Transaction transaction = new Transaction();
                    transaction.setUserId(request.getUserId());
                    transaction.setInitialBalance(1000.0); // Ejemplo: Simulación de saldo inicial
                    transaction.setFinalBalance(1000.0 - request.getAmount());

                    return transactionRepository.save(transaction);
                });
    }

    public Flux<Transaction> getTransactionsByUserId(String userId) {
        return transactionRepository.findByUserId(userId)
                .switchIfEmpty(Flux.error(new ResourceNotFoundException("No se encontraron transacciones para el usuario: " + userId)));
    }
}
