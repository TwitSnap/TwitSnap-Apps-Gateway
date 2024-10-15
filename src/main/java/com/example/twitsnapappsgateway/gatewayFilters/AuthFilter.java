package com.example.twitsnapappsgateway.gatewayFilters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {
    final String BEARER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEyMywibmFtZSI6IlRlc3QgVXNlciIsInJvbGUiOiJ1c2VyIiwiZXhwIjoxNzMyMjc0MzY2fQ.lB8shawWVDL9zELZ1r_2FWDNvt84dy_2GbHh3DxcoL8";

    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // 1. Obtengo el token del header Authorization.
            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            // 2. Verifico si el token coincide con "Bearer asd".
            if (BEARER_TOKEN.equals(token)) {
                // Token válido: Continuar con la solicitud.
                return chain.filter(exchange);
            }

            // Token inválido o no presente: Responder con un 401.
            System.out.println("Invalid or missing token");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        };
    }

    public static class Config {}
}