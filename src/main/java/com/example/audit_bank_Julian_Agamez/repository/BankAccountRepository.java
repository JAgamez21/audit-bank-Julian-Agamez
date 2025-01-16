package com.example.audit_bank_Julian_Agamez.repository;

import com.example.audit_bank_Julian_Agamez.model.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
    Mono<BankAccount> findByAccountNumber(String accountNumber);
}