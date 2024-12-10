package com.ids.argus.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for the entire app
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/api/signup").permitAll() // Allow POST for signup
                .requestMatchers(HttpMethod.POST, "/api/login").permitAll() // Allow POST for login
                .anyRequest().authenticated() // Require authentication for all other requests
            );

        return http.build();
    }

}
