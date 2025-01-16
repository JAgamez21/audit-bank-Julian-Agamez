package com.example.audit_bank_Julian_Agamez.handler;

import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionRequestDTO;
import com.example.audit_bank_Julian_Agamez.service.AuditTransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TransactionHandlerTest {

    @Mock
    private AuditTransactionService transactionService;

    @InjectMocks
    private TransactionHandler transactionHandler;

    public TransactionHandlerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHandleDeposit() {
        AuditTransactionRequestDTO requestDTO = new AuditTransactionRequestDTO();
        requestDTO.setTransactionType("Deposit");
        requestDTO.setAmount(500.0);
        requestDTO.setUserId("12345");

        when(transactionService.processDeposit(any())).thenReturn(Mono.empty());

        StepVerifier.create(transactionHandler.handleDeposit(requestDTO))
                .expectNextCount(0)
                .verifyComplete();
    }
}
