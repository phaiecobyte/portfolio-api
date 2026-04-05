package com.phaiecobyte.portfolio_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupLogger {
    @Value("${server.port}")
    private String port;

    @Bean
    CommandLineRunner logSwaggerUrl(){
        return args -> {
            String baseUrl = "http://localhost:"+port;
            System.out.println("\n🚀 Application Started");
            System.out.println("Swagger UI:"+baseUrl+"/swagger-ui/index.html");
            System.out.println("API Docs :"+ baseUrl + "/v3/api-docs\n");
        };
    }
}
