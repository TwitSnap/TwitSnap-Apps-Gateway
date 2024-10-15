package com.example.twitsnapappsgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.example.twitsnapappsgateway.gatewayFilters.AuthFilter;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}
