package com.project.gymapp.modules.infrastructure.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.gymapp.modules.infrastructure.security.filters.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    SecurityFilter securityFilter;

    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/auth/login").permitAll())
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/user/health").permitAll())
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/user/create").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.PATCH, "/user/update/**").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/user/all ").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/user/name/** ").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/user/mail/** ").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.DELETE, "/user/delete/all ").hasRole("ADMIN"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.DELETE, "/user/delete/").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/product/all").hasAnyRole("ADMIN", "MANAGEMENT", "CUSTOMER"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/product/create").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.DELETE, "/product/delete/**").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/product/**").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/product/product-type/").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.PATCH, "/product/update/**").hasAnyRole("ADMIN", "MANAGEMENT"))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/product/health ").permitAll().anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
