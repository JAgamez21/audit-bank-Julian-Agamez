package com.example.audit_bank_Julian_Agamez.repository;

import com.example.audit_bank_Julian_Agamez.model.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
    Flux<Transaction> findByUserId(String userId);
}
