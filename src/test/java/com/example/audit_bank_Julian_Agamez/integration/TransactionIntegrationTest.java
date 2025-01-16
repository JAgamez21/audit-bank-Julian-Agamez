package com.example.audit_bank_Julian_Agamez.integration;

import com.example.audit_bank_Julian_Agamez.dto.AuditTransactionRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateDeposit() {
        AuditTransactionRequestDTO request = AuditTransactionRequestDTO.builder()
                .transactionType("Deposit")
                .amount(500.0)
                .userId("12345")
                .build();

        webTestClient.post()
                .uri("/api/transactions/deposit")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.transactionType").isEqualTo("Deposit");
    }
}
