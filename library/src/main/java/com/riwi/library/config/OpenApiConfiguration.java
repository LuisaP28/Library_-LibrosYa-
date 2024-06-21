package com.riwi.library.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Api to manage the Spring Boot Drill",
        version = "1.0",
        description = "EndPoint documentation of the spring boot drill application"
    )
)
public class OpenApiConfiguration {
    
}
