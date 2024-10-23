package com.nzhussup.javadatamanagementservice.security;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
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
            registry.requestMatchers("/auth/register").permitAll();
            registry.requestMatchers("/swagger-ui/index.html").permitAll();
            registry.requestMatchers("/swagger-ui/**").permitAll();
            registry.requestMatchers("/v3/api-docs/**").permitAll();
            registry.requestMatchers("/webjars/**").permitAll();
            registry.requestMatchers("/admin/**").hasRole("ADMIN");
            registry.requestMatchers("/public/**").hasAnyRole("USER", "ADMIN");

            registry.anyRequest().authenticated();
        });

        http.exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler())
                .accessDeniedHandler(forbiddenHandler());

        return http.build();
    }

    @Bean
    public AccessDeniedHandler forbiddenHandler() {
        return (request, response, accessDeniedException) -> {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("Forbidden: You do not have permission to access this resource.");
        };
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedHandler() {
        return (request, response, authException) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("Unauthorized: Please provide a valid token.");
        };
    }

}



