package com.fiuni.mytube_gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class CustomCorsFilterConfig {

    @Bean
    public GlobalFilter customCorsFilter() {
        return (exchange, chain) -> {
            exchange.getResponse().getHeaders().set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            return chain.filter(exchange);
        };
    }
}
