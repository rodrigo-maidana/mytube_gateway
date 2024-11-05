package com.fiuni.mytube_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(exchanges -> exchanges
                        .anyExchange().permitAll())  // Permitir todas las solicitudes sin autenticación
                .csrf(ServerHttpSecurity.CsrfSpec::disable); // Deshabilitar CSRF de manera compatible

        return http.build();
    }
}
