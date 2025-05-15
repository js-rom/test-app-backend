package com.js_rom.test_app_backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Profile("dev")
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Deshabilita CSRF (útil si no usas formularios)
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll() // Permite todas las solicitudes
                )
                .formLogin().disable() // Desactiva formulario de login
                .httpBasic().disable(); // Desactiva autenticación HTTP básica

        return http.build();
    }

}
