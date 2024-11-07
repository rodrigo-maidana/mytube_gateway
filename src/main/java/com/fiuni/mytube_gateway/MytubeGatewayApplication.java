package com.fiuni.mytube_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration.class}
)
public class MytubeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytubeGatewayApplication.class, args);
    }

}
