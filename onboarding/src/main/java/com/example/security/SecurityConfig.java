package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;

/* THIS CLASS FOCUSES ON HOW TO SECURE HTTP REQUESTS 
SecurityFilterChain controls authentication, authorization , CSRF for the token
*/


@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean   // returned object added to spring container
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())// disabling csrf(cross site request forgery) protection for stateless jwt auth
            .authorizeHttpRequests(auth -> auth  /*Starts defining authorization rules. Applies rules to incoming HTTP requests. */
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Run my jwtAuthFilter before the UsernamePasswordAuthenticationFilter in the security filter chain.

        return http.build();
    }
}