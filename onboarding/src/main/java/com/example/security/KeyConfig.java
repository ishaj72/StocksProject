package com.example.security;

import java.security.PublicKey;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.security.Keys;

@Configuration
public class KeyConfig {

    @Value("${JWT_SECRET}")
    private String JWT_SECRET;

    @Bean
    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(JWT_SECRET.getBytes()); // converts key to bytes since HMAC work with bytes
    }

    /*Creates a secure HMAC SecretKey . Ensures key length is valid for HS256 */
}
