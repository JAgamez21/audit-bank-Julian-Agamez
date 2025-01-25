package com.example.audit_bank_Julian_Agamez.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AuditBank API")
                        .version("1.0")
                        .description("API for auditing bank transactions in real-time."))
                .openapi("3.0.0");
    }
}
