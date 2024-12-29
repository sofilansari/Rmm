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
            .csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/api/signup").permitAll() 
                .requestMatchers(HttpMethod.POST, "/api/login").permitAll() 
                .requestMatchers("/api/docter/**").permitAll()
                .requestMatchers("/api/address/**").permitAll()
                .requestMatchers("/api/category/**").permitAll()
                .requestMatchers("/api/contact/**").permitAll()
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated() 
            );

        return http.build();
    }

}
