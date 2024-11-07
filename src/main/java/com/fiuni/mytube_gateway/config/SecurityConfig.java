package com.fiuni.mytube_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll() // Permitir todas las solicitudes sin autenticación
                )
                .cors(cors -> cors.disable()) // Configuración de CORS, desactívala si tienes configurado en application.properties
                .csrf(csrf -> csrf.disable()); // Deshabilitar CSRF

        return http.build();
    }
}
