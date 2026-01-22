package com.example.security;

import java.security.PublicKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyConfig {

     @Bean
    public PublicKey publicKey() {
        //will update afterwards
        return null;
    }
    
}
