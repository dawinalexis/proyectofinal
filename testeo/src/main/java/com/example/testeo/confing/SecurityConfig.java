package com.example.testeo.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(requests -> requests
                        .requestMatchers("/registro").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/menu").permitAll()
                        .anyRequest().authenticated())
                .logout(logout -> logout.permitAll());
        return http.build();
    }
}
