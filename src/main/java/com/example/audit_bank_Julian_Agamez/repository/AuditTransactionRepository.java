package com.example.audit_bank_Julian_Agamez.repository;

import com.example.audit_bank_Julian_Agamez.model.AuditTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AuditTransactionRepository extends ReactiveMongoRepository<AuditTransaction, String> {
    Flux<AuditTransaction> findByUserId(String userId);
}