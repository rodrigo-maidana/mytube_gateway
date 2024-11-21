package com.fiuni.mytube_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        //config.addAllowedOrigin("http://localhost:5173"); // Especifica el origen explícitamente
        config.setAllowedOrigins(List.of("*"));
        config.addAllowedMethod("*"); // Permite todos los métodos (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permite todas las cabeceras
        config.setAllowCredentials(true); // Permite credenciales (si las necesitas)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
