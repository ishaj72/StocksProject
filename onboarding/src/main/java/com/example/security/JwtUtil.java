package com.example.security;

import java.security.PublicKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

    private final PublicKey publicKey;

    public JwtUtil(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
