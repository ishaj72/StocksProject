package com.example.security;

import java.security.PublicKey;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

/* 
THIS CLASS FOCUSES ON THE TOKEN VALIDATION USING PUBLIC KEY
jjwt & Claims -> Java JSON Web Token  Library uses claims interfaces.These claims can be iss or exp also.  
Claims are key-value pairs that can contain information for authorization.
Jwts -> utility class to parse and validate JWT tokens.
*/ 

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


@Component
public class JwtUtil {

    private final SecretKey secretKey; 

    public JwtUtil(SecretKey secretKey) {
        this.secretKey = secretKey;
    }
    
    public Claims validateToken(String token) {
        return Jwts.parserBuilder() // verify the signature and validate token structure
                .setSigningKey(secretKey) // sets the secret key to verify the JWT
                .build()      // build the parser instance
                .parseClaimsJws(token)        // signature and token format verfication and exp date check
                .getBody();             // extract the claims from the token
    }
}
