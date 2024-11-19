package com.fiuni.mytube_gateway.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    @Value("${app.jwt.secret}")
    private String secretKey;

    public JwtAuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Obtener el token del header Authorization
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                // Si no hay token o no empieza con "Bearer", retornar 401
                exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            // Extraer el token
            String token = authHeader.substring(7);

            try {
                // Validar el token y extraer los claims
                Claims claims = Jwts.parser()
                        .setSigningKey(secretKey)
                        .parseClaimsJws(token)
                        .getBody();

                // Extraer la informacion relevante
                String roles = claims.get("roles", String.class);
                String userId = claims.getSubject(); // "sub" del token

                // Agregar roles y userId al contexto de la solicitud
                exchange.getAttributes().put("roles", roles);
                exchange.getAttributes().put("userId", userId);

            } catch (Exception e) {
                // Si el token es invalido, retornar 401
                exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            // Continuar con el filtro si el token es valido
            return chain.filter(exchange);
        };
    }

    // Clase de configuracion para extender si es necesario
    public static class Config {
        // Puedes agregar configuraciones personalizadas aqui en el futuro si lo necesitas
    }
}
