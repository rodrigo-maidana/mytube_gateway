package com.fiuni.mytube_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                // Ruta para el servicio de usuarios y suscripciones
                .route("MYTUBE_USERS", r -> r.path("/users/**", "/subscriptions/**")
                        .uri("http://localhost:8081"))

                // Ruta para el servicio de canales, listas de reproducción y videos en listas de reproducción
                .route("MYTUBE_CHANNELS", r -> r.path("/channels/**", "/playlists/**", "/playlist_videos/**")
                        .uri("http://localhost:8082"))

                // Ruta para el servicio de videos, historial de visualización, reacciones y comentarios
                .route("MYTUBE_VIDEOS", r -> r.path("/viewingHistory/**", "/videos/**", "/reactions/**", "/comments/**")
                        .uri("http://localhost:8083"))

                // Ruta para el servicio de autenticación y seguridad
                .route("MYTUBE_SECURITY", r -> r.path("/auth/**")
                        .uri("http://localhost:8084"))

                .build();
    }
}
