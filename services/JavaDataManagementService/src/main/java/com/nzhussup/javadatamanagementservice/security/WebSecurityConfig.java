package com.nzhussup.javadatamanagementservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JWTAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain appSecurity(HttpSecurity http) throws Exception {

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests(registry -> {
            registry.requestMatchers("/").permitAll();
            registry.requestMatchers("/auth/login").permitAll();
            registry.requestMatchers("/swagger-ui/index.html").permitAll();
            registry.requestMatchers("/swagger-ui/**").permitAll();
            registry.requestMatchers("/v3/api-docs/**").permitAll();
            registry.requestMatchers("/webjars/**").permitAll();
            registry.requestMatchers("/admin/**").hasRole("ADMIN");
            registry.requestMatchers("/public/**").hasAnyRole("USER", "ADMIN");

            registry.anyRequest().authenticated();
        });

        return http.build();
    }
}



