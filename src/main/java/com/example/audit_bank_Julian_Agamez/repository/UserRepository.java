package com.example.audit_bank_Julian_Agamez.repository;

import com.example.audit_bank_Julian_Agamez.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUserId(String userId);
    Mono<User> findByEmail(String email);
}