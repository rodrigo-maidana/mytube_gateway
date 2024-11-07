package com.fiuni.mytube_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permitir todas las rutas
                        .allowedOrigins("*") // Permitir todos los orígenes
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permitir todos los métodos HTTP
                        .allowedHeaders("*") // Permitir todos los encabezados
                        .allowCredentials(true); // Permitir credenciales
            }
        };
    }
}