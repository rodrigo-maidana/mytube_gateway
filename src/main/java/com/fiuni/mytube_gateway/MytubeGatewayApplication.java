package com.fiuni.mytube_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class MytubeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytubeGatewayApplication.class, args);
    }

}
