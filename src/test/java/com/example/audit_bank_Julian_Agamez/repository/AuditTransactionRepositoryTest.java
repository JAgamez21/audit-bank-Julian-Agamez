package com.example.audit_bank_Julian_Agamez.repository;

import com.example.audit_bank_Julian_Agamez.model.AuditTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataMongoTest
public class AuditTransactionRepositoryTest {

    @Autowired
    private AuditTransactionRepository transactionRepository;

    @Test
    void testSaveTransaction() {
        AuditTransaction transaction = new AuditTransaction();
        transaction.setTransactionType("Deposit");
        transaction.setTransactionAmount(500.0);
        transaction.setUserId("12345");

        Mono<AuditTransaction> savedTransaction = transactionRepository.save(transaction);

        StepVerifier.create(savedTransaction)
                .expectNextMatches(saved -> saved.getTransactionType().equals("Deposit"))
                .verifyComplete();
    }
}
